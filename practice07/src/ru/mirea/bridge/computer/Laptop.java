package ru.mirea.bridge.computer;

import ru.mirea.bridge.network.Network;

/**
 * Ноутбук, реализующий абстракцию компьютер
 */
public class Laptop implements Computer {
    protected boolean working;
    protected Network network;

    public Laptop() {
        working = false;
    }

    public Laptop(Network network) {
        this.network = network;
        working = false;
    }

    @Override
    public void launch() {
        if (working) {
            System.out.println("Computer is already launched");
            return;
        }
        System.out.println("Computer: launch & connect to the network");
        network.connectToInternet();
        working = true;
    }

    @Override
    public void shutDown() {
        if (!working) {
            System.out.println("Computer is not working");
            return;
        }
        System.out.println("Computer: shut down & disconnect from the network");
        network.disconnect();
        working = false;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "working=" + working +
                ", network=" + network +
                '}';
    }
}
