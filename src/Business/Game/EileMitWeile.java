
package Business.Game;

import Business.Board.Board;
import Presentation.InOutput.IO;
import Business.Player.Dice;
import Business.Player.Player;

import java.util.ArrayList;

public class EileMitWeile implements Runnable {
    private boolean finish = false;
    private Dice d;
    private ArrayList<Player> players = new ArrayList<Player>(Board.MAX_PLAYER);
    private Board board;
    private int numPlayers;

    public EileMitWeile() {
        board = new Board();
        for (int i = 0; i < Board.MAX_PLAYER; i++) {
            players.add(i, new Player(i, board));
        }
    }

    private static boolean isGameFinished = false;

    public void run() {
        int currentPlayerIndex = 0;

        numPlayers = IO.readInputHowManyPlayers();
        IO.gameWasStarted(numPlayers);

        while (isGameFinished != true) {
            IO.pleaseEnterForThrowDice();
            IO.readEnter();
            Dice.getInstance().rollDice();

            // TODO: Ask player, which piece he want move, actually can be move only one piece

            // Pieces will be move, choose which piece must be move is not yet implemented
            players.get(currentPlayerIndex).movePieceBy(0, Dice.getInstance().getLastRoll());

            // TODO: Game logic must implemented here, example: rules

            // Fields will be show on the console
            IO.showFields(board.toString());

            // Check, is anyone on the heaven field?
            if (board.getHeaven().get(0).hasPieceOnField()) {
                isGameFinished = true;
                continue;
            }

            currentPlayerIndex++;
            if (currentPlayerIndex >= numPlayers) {
                currentPlayerIndex = 0;
            }
        }
        IO.gameIsFinishedShowTheWinner(currentPlayerIndex);
    }
}