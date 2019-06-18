package Business.Board;

import Business.Player.Piece;

public class Heaven extends Field {

    public Heaven() {

    }

    @Override
    public String toString() {
        String s = "H";

        // Go through linked list and append all stones to string s
        for (Piece p : piecesOnField) {
            s += "-P" + p.getOwner().getPlayerID() + "p" + p.getID();
        }

        return s;
    }
}
