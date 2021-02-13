package ru.mirea.abstractFactory;

public interface AgileTeamFactory {
    ProductManager getProductManager();

    SoftwareDeveloper getSoftwareDeveloper();
}
