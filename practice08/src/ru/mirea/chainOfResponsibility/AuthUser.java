package ru.mirea.chainOfResponsibility;

/**
 * Сущность пользователя для авторизации
 */
public class AuthUser {
    private final String login;
    private final String password;
    private final boolean isAllowed;

    public AuthUser(String login, String password) {
        this.login = login;
        this.password = password;
        this.isAllowed = true;
    }

    public AuthUser(String login, String password, boolean isAllowed) {
        this.login = login;
        this.password = password;
        this.isAllowed = isAllowed;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAllowed() {
        return isAllowed;
    }
}
