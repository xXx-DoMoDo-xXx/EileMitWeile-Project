package Business.Board;

import Business.Player.Piece;

public class Home extends Field {

    public Home() {

    }

    @Override
    public String toString() {
        String s = "h";

        // Go through linked list and append all stones to string s
        for (Piece p : piecesOnField) {
            s += "-P" + p.getOwner().getPlayerID() + "p" + p.getID();
        }

        return s;
    }
}
