package ru.mirea.chainOfResponsibility;

import ru.mirea.chainOfResponsibility.handlers.Base;

import java.util.HashMap;
import java.util.Map;

/**
 * Имитация сервера
 */
public class FakeServer {
    private final Map<String, AuthUser> users;
    private Base base;

    public FakeServer() {
        this.users = new HashMap<>();
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public boolean signIn(AuthUser user) {
        if (base.check(user)) {
            System.out.println("Auth was successful");
            return true;
        }
        return false;
    }

    public void register(AuthUser user) {
        users.put(user.getLogin(), user);
    }

    public boolean isPasswordCorrect(String login, String pwd) {
        return users.get(login).getPassword().equals(pwd);
    }

    public boolean doesExist(String login) {
        return users.containsKey(login);
    }
}
