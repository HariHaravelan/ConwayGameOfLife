public class Grid {
    private Cell[][] cells;

    public Grid(int size, Randomizer randomizer) {
        this.cells = randomizer.loadCells(size);
    }


    public boolean isOutOfBound(int maxSize, int i, int j) {
        return (i < 0 || i == maxSize) || (j < 0 || j == maxSize);
    }


    int getAliveNeighboursCount(int xPos, int yPos) {
        int aliveNeighboursCount = 0;
        for (int i = xPos - 1; i <= xPos + 1; i++) {
            for (int j = yPos - 1; j <= yPos + 1; j++) {
                if (isOutOfBound(cells.length, i, j) || (i == xPos && j == yPos)) {
                    continue;
                }
                aliveNeighboursCount += cells[i][j].isAlive() ? 1 : 0;
            }
        }
        return aliveNeighboursCount;
    }

    public void updateCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void nextCycle() {
        Cell[][] newCells = new Cell[this.cells.length][this.cells[0].length];
        for (int i = 0; i < newCells.length; i++) {
            for (int j = 0; j < newCells[0].length; j++) {
                Cell cell = new Cell(false);
                cell.updateStatus(getAliveNeighboursCount(i, j));
                newCells[i][j] = cell;
            }
        }
        updateCells(newCells);
    }

    @Override
    public String toString() {
        StringBuilder gridString = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                gridString.append(cells[i][j].isAlive() ? "*\t" : "-\t");
            }
            gridString.append("\n");
        }
        return gridString.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Randomizer randomizer = new Randomizer(4);
        Grid grid = new Grid(4, randomizer);
        System.out.println(grid);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            grid.nextCycle();
            System.out.println(grid);
        }
    }
}
