package Presentation.InOutput;

import Business.Board.Board;

import java.util.Scanner;

public class IO {

    public static void readEnter() {
        Scanner scanner = new Scanner(System.in);
        String enterkey;
        enterkey = scanner.nextLine();
        if(enterkey.equals(""));
    }

    public static int readInputHowManyPlayers() {
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players? (maximum " + Board.MAX_PLAYER + " player/s)");
        value = scanner.nextInt();
        while((value > Board.MAX_PLAYER) || (value < 1 )) {
            System.out.println("Invalid number, please again. How many players? (actually maximum " + Board.MAX_PLAYER + " player/s)");
            value = scanner.nextInt();
        }
        return value;
    }

    public static void shouldTheGamebeStarted() {
        System.out.println("If you want to start the game, please press Enter.");
        readEnter();
    }

    public static void gameWasStarted(int value) {
        System.out.println("The Game was started with " + value + " player/s");
    }

    public static void showFields(String s) {
        System.out.println(s);
    }

    public static void gameIsFinishedShowTheWinner(int index) {
        System.out.println("The winner is: Player Number " + index + ", congratulation!!!");
    }

    public static void pleaseEnterForThrowDice(){
        System.out.println("\r\nplease press enter for throw dice");
    }

}
