package ru.mirea.bridge;

import ru.mirea.bridge.computer.CyberLaptop;
import ru.mirea.bridge.computer.Laptop;
import ru.mirea.bridge.network.MobileData;
import ru.mirea.bridge.network.Network;
import ru.mirea.bridge.network.WiFi;

/**
 * Демонстрация работы паттерна "Мост"
 */
public class Demo {

    public static void main(String[] args) {
        testNetwork(new MobileData());
        testNetwork(new WiFi());
    }

    public static void testNetwork(Network network) {
        System.out.println("Test laptop:");
        Laptop laptop = new Laptop(network);
        laptop.launch();
        System.out.println(laptop);
        laptop.shutDown();
        System.out.println(laptop);
        System.out.println("-------------------------");

        System.out.println("Test cyber laptop:");
        CyberLaptop cyberLaptop = new CyberLaptop(network);
        cyberLaptop.launch();
        System.out.println(cyberLaptop);
        cyberLaptop.shutDown();
        System.out.println(cyberLaptop);
        cyberLaptop.makeConnectedPermanently();
        System.out.println(cyberLaptop);
        System.out.println("-------------------------");
    }
}
