package ru.mirea;

/**
 * Метод ленивой загрузки (Lazy Load Method)
 */
public class Singleton4 {
    private Singleton4() {}
    private static class NestedSingleton {
        static final Singleton4 SINGLE_INST = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return NestedSingleton.SINGLE_INST;
    }
}
