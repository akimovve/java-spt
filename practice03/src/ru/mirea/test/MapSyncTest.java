package ru.mirea.test;

import ru.mirea.MapSync;

import java.util.Map;

public class MapSyncTest {
    private static Map<Integer, String> mapSync = new MapSync<>();

    public static void test() {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 51; i++) {
                addElToMapSync(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 51; i < 101; i++) {
                addElToMapSync(i);
            }
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync map:");
        mapSync.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void addElToMapSync(int idx) {
        mapSync.put(idx, "el_" + idx);
    }
}
