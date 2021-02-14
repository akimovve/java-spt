package ru.mirea.chainOfResponsibility.handlers;

import ru.mirea.chainOfResponsibility.AuthUser;
import ru.mirea.chainOfResponsibility.FakeServer;

/**
 * Обработчик для проверки логина и пароля
 */
public class DataValidation extends Base {
    private final FakeServer server;

    public DataValidation(FakeServer server) {
        this.server = server;
    }

    @Override
    public boolean check(AuthUser user) {
        if (!server.doesExist(user.getLogin())) {
            System.out.println("User with this login wasn't found");
            return false;
        }
        if (!server.isPasswordCorrect(user.getLogin(), user.getPassword())) {
            System.out.println("Password is incorrect");
            return false;
        }
        return checkNext(user);
    }
}
