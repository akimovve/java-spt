package ru.mirea.factory;

public interface AgileFrameworkFactory {
    static AgileFramework getAgileFramework(AgileFramework.AgileType type) {
        return type.getFramework().get();
    }
}
