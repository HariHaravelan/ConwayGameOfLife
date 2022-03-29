package com.conway.game;

import java.util.Random;

public class Randomizer {

    private int aliveCellsForEveryTenCell;

    public Randomizer(int aliveCellsForEveryTenCell) {
        this.aliveCellsForEveryTenCell = aliveCellsForEveryTenCell;
    }

    private boolean getNext() {
        return new Random().nextInt(10) <= aliveCellsForEveryTenCell;
    }

    public Cell[][] loadCells(int size) {
        Cell[][] cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell(getNext());
            }
        }
        return cells;
    }
}
