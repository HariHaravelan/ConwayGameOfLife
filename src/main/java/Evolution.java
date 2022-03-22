public class Evolution {
    public static void main(String[] args) throws InterruptedException {
        Randomizer randomizer = new Randomizer(3);
        Grid grid = new Grid(4, randomizer);
        System.out.println(grid);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(100);
            grid.nextCycle();
            System.out.println(grid);
        }
    }
}
