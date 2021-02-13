package ru.mirea.abstractFactory.enterprise;

import ru.mirea.abstractFactory.SoftwareDeveloper;

public class EnterpriseSoftwareDeveloper implements SoftwareDeveloper {
    @Override
    public void develop() {
        System.out.println("SD works on enterprise project");
    }
}
