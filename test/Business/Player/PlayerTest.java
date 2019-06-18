package Business.Player;

import Business.Board.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class PlayerTest {

    @Test
    void createHomeFieldsTest() {
        Board board = new Board();
        ArrayList<Player> players = new ArrayList<Player>(Board.MAX_PLAYER);

        for (int i = 0; i < Board.MAX_PLAYER; i++) {
            players.add(i, new Player(i, board));
        }

        for (int i = 0; i < Board.MAX_PLAYER; i++) {
            assertTrue(board.getHomeByPlayerID(i).equals(players.get(i).getHomesOfPlayer()));
        }
    }

    @Test
    void leaveHomeTest() {
        Board board = new Board();
        ArrayList<Player> players = new ArrayList<Player>(Board.MAX_PLAYER);

        for (int i = 0; i < Board.MAX_PLAYER; i++) {
            players.add(i, new Player(i, board));
        }

        players.get(0).movePieceBy(0, 1);
        assertTrue(players.get(0).getHomesOfPlayer().get(0).equals(players.get(0).getPieces().get(0).getOnField()));
        assertTrue(players.get(0).getHomesOfPlayer().get(0).hasPieceOnField());

        players.get(0).movePieceBy(0, 5);
        assertFalse(players.get(0).getHomesOfPlayer().get(0).equals(players.get(0).getPieces().get(0).getOnField()));
        assertTrue(players.get(0).getFieldsOfPlayer().get(0).equals(players.get(0).getPieces().get(0).getOnField()));
        assertFalse(players.get(0).getHomesOfPlayer().get(0).hasPieceOnField());
    }

    @Test
    void movePieceTest() {
        Board board = new Board();
        ArrayList<Player> players = new ArrayList<Player>(Board.MAX_PLAYER);

        for (int i = 0; i < Board.MAX_PLAYER; i++) {
            players.add(i, new Player(i, board));
        }

        players.get(0).movePieceBy(0, 5);
        assertTrue(players.get(0).getFieldsOfPlayer().get(0).equals(players.get(0).getPieces().get(0).getOnField()));
        players.get(0).movePieceBy(0, 6);
        assertTrue(players.get(0).getFieldsOfPlayer().get(6).equals(players.get(0).getPieces().get(0).getOnField()));

    }
}