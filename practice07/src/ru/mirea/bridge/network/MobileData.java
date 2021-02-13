package ru.mirea.bridge.network;

/**
 * Мобильный интернет, реализующий абстракцию сеть
 */
public class MobileData implements Network {
    private boolean connected;

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void connectToInternet() {
        connected = true;
    }

    @Override
    public void disconnect() {
        connected = false;
    }

    @Override
    public String toString() {
        return "MobileData{" +
                "connected=" + connected +
                '}';
    }
}
