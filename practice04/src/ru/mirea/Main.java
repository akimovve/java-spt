package ru.mirea;

import java.util.concurrent.*;

public class Main {

    static class Test {
        public Test() throws InterruptedException {
            Thread.sleep(200);
            System.out.println("Test class constructor");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(13);
        executor.submit(Test::new);
        Future<String> future = executor.submit(() -> "Second submit");
        executor.shutdown(); // Останавливает потоки после их самостоятельного завершения
        // executor.shutdownNow(); // Принудительно останавливает все потоки разом
        if (future.isDone() && !future.isCancelled()) {
            System.out.println("Future result: " + future.get());
        }
    }
}
