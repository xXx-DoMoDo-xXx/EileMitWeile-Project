package Business.Board;

import Business.Player.Piece;

public class Stair extends Field {

    public Stair() {

    }

    @Override
    public String toString() {
        String s = "s";

        // Go through linked list and append all stones to string s
        for (Piece p : piecesOnField) {
            s += "-P" + p.getOwner().getPlayerID() + "p" + p.getID();
        }

        return s;

    }
}