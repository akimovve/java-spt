package ru.mirea;

/**
 * При помощи перечисления (Enum Method)
 */
public enum Singleton2 {
    SINGLE_INST;
    public static Singleton2 getInstance() {
        return SINGLE_INST;
    }
}
