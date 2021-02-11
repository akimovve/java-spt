package ru.mirea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Human> people = new ArrayList<Human>() {{
            add(new Human(19, "Oleg", "Sergeev", LocalDate.of(2001, 11, 21), 65));
            add(new Human(19, "Ivan", "Asmanov", LocalDate.of(2000, 12, 1), 72));
            add(new Human(20, "Max", "Zomov", LocalDate.of(1999, 5, 17), 70));
            add(new Human(17, "Timur", "Olegov", LocalDate.of(2003, 2, 3), 63));
        }};

        System.out.println("Сортировка по имени:");
        people.stream()
                .sorted(Comparator.comparing(Human::getFirstName))
                .forEach(System.out::println);
        System.out.println("\nФильтрация по дате рождения большей, чем 24 июня 2000:");
        people.stream()
                .filter(human -> human.getBirthDate().isAfter(LocalDate.of(2000, 6, 24)))
                .forEach(System.out::println);
        System.out.println("\nСортировка по фамилии:");
        people.stream()
                .sorted(Comparator.comparing(Human::getLastName))
                .forEach(System.out::println);
        System.out.print("\nСумма всех возрастов: ");
        int sumOfAges = people.stream()
                .mapToInt(Human::getAge)
                .sum();
        System.out.println(sumOfAges);
    }
}
