package Business.Player;

import Business.Board.Board;
import Business.Board.Field;
import Business.Board.Home;

import java.util.ArrayList;

public class Player {
    private int id;
    private Board board;
    private ArrayList<Home> homesOfPlayer = new ArrayList<Home>();
    private ArrayList<Field> fieldsOfPlayer = new ArrayList<Field>();
    private ArrayList<Piece> pieces = new ArrayList<Piece>(Board.MAX_PIECE);

    public Player(int id, Board board) {
        this.id = id;
        this.board = board;

        homesOfPlayer.addAll(board.getHomeByPlayerID(id));

        fieldsOfPlayer.addAll(board.getFields());                  // FIXME: here fix it, actually will be all player start on the same fields, normally has every players a offset
        fieldsOfPlayer.addAll(board.getStairsByPlayerID(id));      // FIXME: see before
        fieldsOfPlayer.addAll(board.getHeaven());

        for (int i = 0; i < Board.MAX_PIECE; i++) {
            pieces.add(i, new Piece(this, i, homesOfPlayer.get(i)));
        }
    }

    public void movePieceBy(int pieceId, int steps) {
        Piece piece = pieces.get(pieceId);
        Field fieldOfPiece = piece.getOnField();

        // is fields in the list?
        if (fieldsOfPlayer.contains(fieldOfPiece)) {
            /* Ja */
            int index = fieldsOfPlayer.indexOf(fieldOfPiece) + steps;
            if (index >= fieldsOfPlayer.size()) {
                index = fieldsOfPlayer.size() - 1;
            }
            // move the piece --> fields save in piece
            fieldsOfPlayer.get(index).AddPieceToField(piece);
        } else {
            // no, piece is in the home
            if (steps == 5) {
                /* Stein auf Feld 0 */
                fieldsOfPlayer.get(0).AddPieceToField(piece);
            }
        }
    }

    public int getPlayerID() {
        return id;
    }


    public ArrayList<Home> getHomesOfPlayer() {
        return homesOfPlayer;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Field> getFieldsOfPlayer() {
        return fieldsOfPlayer;
    }

}
