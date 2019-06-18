package Business.Player;

import Business.Board.Field;
import Business.Board.Home;

public class Piece {
    private Player owner;
    private int id;
    private Field onField;

    public Piece(Player owner, int id, Home home) {
        this.owner = owner;
        this.id = id;

        // onField will be set automatic
        home.AddPieceToField(this);
    }

    public Field getOnField() {
        return onField;
    }

    public void setOnField(Field onField) {
        this.onField = onField;
    }

    public Player getOwner() {
        return owner;
    }

    public int getID() {
        return id;
    }
}
