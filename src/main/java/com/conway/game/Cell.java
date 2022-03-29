package com.conway.game;

public class Cell {
    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public void updateStatus(int aliveNeighboursCount) {
        if (alive && aliveNeighboursCount > 3) {
            alive = false;
        } else if (alive && aliveNeighboursCount < 2) {
            alive = false;
        } else if (aliveNeighboursCount == 3 && !alive) {
            alive = true;
        }
    }

    public boolean isAlive() {
        return this.alive;
    }
}
