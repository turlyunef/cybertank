package ru.cybertank.evrodens.bot;

public class Step {
    private final int x;
    private final int y;

    public Step(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
