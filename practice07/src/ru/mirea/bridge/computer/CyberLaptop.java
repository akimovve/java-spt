package ru.mirea.bridge.computer;

import ru.mirea.bridge.network.Network;

/**
 * Киберноутбук, расширяющий функционал обычного ноутбука
 */
public class CyberLaptop extends Laptop {
    public CyberLaptop(Network network) {
        super(network);
    }

    public void makeConnectedPermanently() {
        System.out.println("Computer: permanently connected whether it works or not");
        if (!network.isConnected()) {
            network.connectToInternet();
        }
    }

    @Override
    public String toString() {
        return "CyberLaptop{" +
                "working=" + working +
                ", network=" + network +
                '}';
    }
}
