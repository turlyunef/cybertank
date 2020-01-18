package ru.cybertank.evrodens.domain;

import java.util.Arrays;

public class Field {

    private final int fieldSize = 10;
    private Cell[][] field;

    public Field() {
        field = new Cell[fieldSize][fieldSize];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Cell(i, j, CellStatus.CLOSED);
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }

    public void setField(Cell[][] field) {
        this.field = field;
    }

    public Cell findWounded() {
        return Arrays.stream(field)
                .flatMap(Arrays::stream)
                .filter(x -> x.getStatus().equals(CellStatus.WOUNDED))
                .findFirst()
                .orElse(null);
    }

    public Cell getCellByCoordinate(int x, int y) {
        return field[x][y];
    }

    public void changeCellStatus(Cell cell) {
        this.field[cell.getX()][cell.getY()].setStatus(cell.getStatus());
        if (cell.getStatus().equals(CellStatus.KILLED)) {
            updateEmptyCells(cell);
        }
    }

    private void updateEmptyCells(Cell cell) {
        int rowIndex = cell.getY();
        int colIndex = cell.getX();
        for (int i = rowIndex - 1; i <= rowIndex + 1; i++) {
            for (int j = colIndex - 1; j <= colIndex + 1; j++) {
                if (isCellExist(i, j)) {
                    updateCell(i, j);
                }
            }
        }
    }

    private void updateCell(int i, int j) {
        Cell cell = getCellByCoordinate(i, j);
        if (cell.getStatus().equals(CellStatus.CLOSED)) {
            cell.setStatus(CellStatus.MISSED);
        }
    }

    private boolean isCellExist(int rowIndex, int colIndex) {
        return !((rowIndex < 0) || (colIndex < 0) ||
                (rowIndex > fieldSize) ||
                (colIndex > fieldSize));
    }

}
