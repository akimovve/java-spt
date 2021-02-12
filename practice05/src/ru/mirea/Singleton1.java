package ru.mirea;

/**
 * Метод нетерпеливой реализации (Eager Initialization Method)
 */
public class Singleton1 {
    private static final Singleton1 SINGLE_INST = new Singleton1();
    private Singleton1() {}
    public static Singleton1 getInstance() {
        return SINGLE_INST;
    }
}
