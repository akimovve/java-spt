package ru.mirea.adapter;

/**
 * Российская вилка
 */
public class RussianPlug {
    private final int pins;

    public RussianPlug() {
        this.pins = 2;
    }

    public RussianPlug(int pins) {
        this.pins = pins;
    }

    public int getPins() {
        return pins;
    }
}
