package com.theinvader360.sitters;

import com.badlogic.gdx.utils.Array;

public final class Board {
    private Array<Cell> cells;

    public Board() {
        cells = new Array<Cell>();
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 7; x++) {
                Cell cell = new Cell(x, y);
                if (y == 0) {
                    cell.setCellType(Cell.CellType.COLLECTOR);
                }
                if ((y > 2 && y < 8 && x != 3) || (y == 8 && (x == 2 || x == 4))) {
                    cell.setCellType(Cell.CellType.CONTAINER);
                }
                if ((y == 8 && (x == 0 || x == 6)) || (y == 9 && (x < 2 || x > 4))) {
                    cell.setCellType(Cell.CellType.OBSTRUCTOR);
                }
                if (y == 10 && x >= 2 && x <= 4) {
                    cell.setCellType(Cell.CellType.SAFE);
                }
                if (y == 10 && (x < 2 || x > 4)) {
                    cell.setCellType(Cell.CellType.DUMMY);
                }
                cells.add(cell);
            }
        }
    }

    public Array<Cell> getCells() {
        return cells;
    }

    public Cell getCell(int x, int y) {
        return cells.get(x + y * 7);
    }

}
