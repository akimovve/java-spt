package ru.mirea.chainOfResponsibility.handlers;

import ru.mirea.chainOfResponsibility.AuthUser;

/**
 * Базовый обработчик
 */
abstract public class Base {
    private Base nextBase;

    public Base add(Base base) {
        nextBase = base;
        return nextBase;
    }

    protected boolean checkNext(AuthUser user) {
        return nextBase == null || nextBase.check(user);
    }

    abstract public boolean check(AuthUser user);
}
