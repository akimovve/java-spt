package ru.mirea.adapter;

/**
 * Демонстрация работы паттерна "Адаптер"
 */
public class Demo {

    public static void main(String[] args) {
        Socket socket = new Socket(2);
        RussianPlug rp1 = new RussianPlug();
        System.out.println("RP1 fits: " + socket.startCharging(rp1));

        RussianPlug rp2 = new RussianPlug(1); // Ошибка инициализации
        System.out.println("RP2 fits: " + socket.startCharging(rp2));

        AmericanPlug ap1 = new AmericanPlug();
        // socket.startCharging(ap1); // Ошибка компиляции

        AmericanPlugAdapter adapter = new AmericanPlugAdapter(ap1);
        System.out.println("AP1 fits with adapter: " + socket.startCharging(adapter));
    }
}
