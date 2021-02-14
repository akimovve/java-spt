package ru.mirea.command;

import java.time.LocalTime;

/**
 * Демонстрация использования поведенческого паттерна "команда"
 */
public class Demo {

    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Setting turnOn1 = new TurnAlarmOn(alarm, LocalTime.now());
        Setting turnOn2 = new TurnAlarmOn(alarm, LocalTime.of(7, 50));
        Setting turnOff = new TurnAlarmOff(alarm);

        Person person = new Person();
        person.addSetting(turnOn1);
        person.addSetting(turnOn2);
        person.addSetting(turnOff);

        person.executeAll();
    }
}
