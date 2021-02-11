package ru.mirea.test;

import ru.mirea.ListSync;

import java.util.List;

public class ListSyncTest {
    private static List<Integer> listSync = new ListSync<>();

    public static void test() {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 51; i++) {
                addElToListSync(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 51; i < 101; i++) {
                addElToListSync(i);
            }
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync list:");
        listSync.forEach(System.out::println);
    }

    private static void addElToListSync(int idx) {
        listSync.add(idx);
    }
}
