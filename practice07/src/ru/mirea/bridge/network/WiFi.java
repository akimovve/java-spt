package ru.mirea.bridge.network;

/**
 * WiFi, реализующий абстракцию сеть
 */
public class WiFi implements Network {
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
        return "WiFi{" +
                "connected=" + connected +
                '}';
    }
}
