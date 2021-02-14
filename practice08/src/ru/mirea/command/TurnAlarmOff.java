package ru.mirea.command;

/**
 * Реализация выключения будильника
 */
public class TurnAlarmOff implements Setting {
    private final Alarm alarm;

    public TurnAlarmOff(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.turnOff();
    }
}
