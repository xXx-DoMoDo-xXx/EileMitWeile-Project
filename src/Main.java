import Business.Game.EileMitWeile;
import Presentation.InOutput.IO;

public class Main {

    public static void main(String[] args) {
        IO.shouldTheGamebeStarted();

        EileMitWeile eilemitweile = new EileMitWeile();
        eilemitweile.run();
    }
}
