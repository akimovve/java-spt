package ru.mirea.command;

import java.time.LocalTime;

/**
 * Сущность будильник
 */
public class Alarm {
    public LocalTime time;

    public void turnOn(LocalTime time) {
        System.out.println("Alarm is set for " + time);
        this.time = time;
    }

    public void turnOff() {
        System.out.printf("Alarm %s is off%n", time);
        time = null;
    }
}
