package Business.Board;

import Business.Player.Piece;

import java.util.LinkedList;

public class Field {
    protected LinkedList<Piece> piecesOnField = new LinkedList<>();

    public void AddPieceToField(Piece piece) {
        if (piece.getOnField() != null) {
            piece.getOnField().RemovePieceFromField(piece);
        }
        piece.setOnField(this);
        piecesOnField.add(piece);
    }

    public void RemovePieceFromField(Piece piece) {
        piecesOnField.remove(piece);
    }

    public boolean hasPieceOnField() {
        return piecesOnField.size() != 0;
    }

    @Override
    public String toString() {
        String s = "f";

        // Go through linked list and append all stones to string s
        for (Piece p : piecesOnField) {
            s += "-P" + p.getOwner().getPlayerID() + "p" + p.getID();
        }

        return s;
    }
}
