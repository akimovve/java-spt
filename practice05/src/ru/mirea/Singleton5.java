package ru.mirea;

/**
 * Метод ленивой инициализации с двойной блокировкой (Lazy Initialization With Double Lock Method)
 */
public class Singleton5 {
    private static Singleton5 SINGLE_INST;
    private Singleton5() {}
    public static Singleton5 getInstance() {
        if (SINGLE_INST == null) {
            synchronized (Singleton5.class) {
                if (SINGLE_INST == null) {
                    SINGLE_INST = new Singleton5();
                }
            }
        }
        return SINGLE_INST;
    }
}
