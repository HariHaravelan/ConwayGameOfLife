import java.util.Random;

public class Randomizer {

    private int aliveCellsForTen;

    public Randomizer(int aliveCellsForTen) {
        this.aliveCellsForTen = aliveCellsForTen;
    }

    public boolean getNext() {
        return new Random().nextInt(10) < aliveCellsForTen;
    }
}
