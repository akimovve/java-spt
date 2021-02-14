package ru.mirea.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Сущность человек, настраивающая будильник
 */
public class Person {
    private final List<Setting> settings;

    public Person() {
        settings = new ArrayList<>();
    }

    public void addSetting(Setting setting) {
        settings.add(setting);
    }

    public void executeAll() {
        settings.forEach(Setting::execute);
        settings.clear();
    }
}
