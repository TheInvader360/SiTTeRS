package com.theinvader360.sitters;

public class Cell {
    private int x;
    private int y;
    private CellType cellType;
    public enum CellType { DEFAULT, COLLECTOR, CONTAINER, OBSTRUCTOR, SAFE, DUMMY }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.cellType = CellType.DEFAULT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

}
