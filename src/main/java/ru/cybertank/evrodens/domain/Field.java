package ru.cybertank.evrodens.domain;

import java.util.Arrays;

public class Field {

    private Cell[][] field;

    public Field() {
    }

    public Cell[][] getField() {
        return field;
    }

    public void setField(Cell[][] field) {
        this.field = field;
    }

    public Cell findWounded(){
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
    }

}
