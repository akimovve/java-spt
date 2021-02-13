package ru.mirea.adapter;

/**
 * Американская вилка
 */
public class AmericanPlug {
    private final int pins;

    public AmericanPlug() {
        this.pins = 3;
    }

    public AmericanPlug(int pins) {
        this.pins = pins;
    }

    public int getPins() {
        return pins;
    }
}
