package ru.mirea.command;

import java.time.LocalTime;

/**
 * Реализация установки будильника
 */
public class TurnAlarmOn implements Setting {
    private final Alarm alarm;
    private final LocalTime time;

    public TurnAlarmOn(Alarm alarm, LocalTime time) {
        this.alarm = alarm;
        this.time = time;
    }

    @Override
    public void execute() {
        if (time == null) {
            System.out.println("Time is not set");
            return;
        }
        alarm.turnOn(time);
    }
}
