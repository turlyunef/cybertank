package ru.cybertank.evrodens.domain;

public class Cell {

    private int x;
    private int y;
    private CellStatus status;

    public Cell(int x, int y, CellStatus cellStatus) {
        status = cellStatus;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

}
