package ru.cybertank.evrodens.domain;

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
    }

    public void changeCellStatus(Cell cell) {
        this.field[cell.getX()][cell.getY()].setStatus(cell.getStatus());
    }

}
