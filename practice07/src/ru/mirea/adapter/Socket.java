package ru.mirea.adapter;

/**
 * Розетка
 */
public class Socket {
    private final int holes;

    public Socket(int holes) {
        this.holes = holes;
    }

    public int getHoles() {
        return holes;
    }

    public boolean startCharging(RussianPlug russianPlug) {
        return holes == russianPlug.getPins();
    }
}
