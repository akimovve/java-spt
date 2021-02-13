package ru.mirea.abstractFactory.enterprise;

import ru.mirea.abstractFactory.ProductManager;

public class EnterpriseProductManager implements ProductManager {
    @Override
    public void manage() {
        System.out.println("PM manages enterprise project");
    }
}
