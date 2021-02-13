package ru.mirea.abstractFactory.enterprise;

import ru.mirea.abstractFactory.AgileTeamFactory;
import ru.mirea.abstractFactory.SoftwareDeveloper;
import ru.mirea.abstractFactory.ProductManager;

public class EnterpriseTeam implements AgileTeamFactory {
    @Override
    public ProductManager getProductManager() {
        return new EnterpriseProductManager();
    }

    @Override
    public SoftwareDeveloper getSoftwareDeveloper() {
        return new EnterpriseSoftwareDeveloper();
    }
}
