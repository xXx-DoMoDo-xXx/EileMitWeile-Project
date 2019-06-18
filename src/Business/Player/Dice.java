package Business.Player;

public class Dice {
    static private Dice instance = null;
    private int lastRoll;

    public static Dice getInstance() {      // Singleton
        if (instance == null) {
            instance = new Dice();
        }

        return instance;
    }

    public void rollDice() {
        int max = 6;
        int min = 1;
        int range = max - min + 1;

        for (int i = 0; i < 1; i++) {                          // roll dice once
            int rand = (int) (Math.random() * range) + min;
            this.lastRoll = rand;
            System.out.println("The diced number is " + rand + "\r\n");
        }
    }

    public int getLastRoll() {
        return lastRoll;
    }
}
