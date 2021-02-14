package ru.mirea.chainOfResponsibility;

import ru.mirea.chainOfResponsibility.handlers.Access;
import ru.mirea.chainOfResponsibility.handlers.Base;
import ru.mirea.chainOfResponsibility.handlers.DataValidation;

import java.util.Scanner;

/**
 * Демонстрация использования поведенческого паттерна "цепочка обязанностей"
 */
public class Demo {

    public static void main(String[] args) {
        FakeServer server = new FakeServer();
        server.register(new AuthUser("username1", "12345"));
        server.register(new AuthUser("username2", "qwerty"));

        Base base = new Access();
        base.add(new DataValidation(server));
        // Можно добавить ещё обработчиков в цепочку
        server.setBase(base);

        Scanner scanner = new Scanner(System.in);
        boolean logged;
        do {
            System.out.print("Логин: ");
            String login = scanner.nextLine();
            System.out.print("Пароль: ");
            String password = scanner.nextLine();
            System.out.print("Доступ: ");
            String access = scanner.nextLine();
            logged = server.signIn(new AuthUser(login, password,
                    access.equals("1")));
            System.out.println("----------------");
        } while (!logged);
    }
}
