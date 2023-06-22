package de.lubowiecki.oca.playground.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

    public static void main(String[] args) {

        System.out.println("START");

        // SingleThreadExecutor: Service mit einem Worker-Thread
        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable aufgabe = () -> {
            for (int i = 0; i < 10 ; i++) {
                System.out.println(i);
            }
        };

        Callable<Integer> aufgabe2 = () -> {
            return 10;
        };

        service.execute(aufgabe); // main übergibt die Aufgabe und geht sofort weiter
        service.execute(aufgabe);
        service.submit(aufgabe);
        service.submit(aufgabe);
        service.submit(aufgabe);
        service.submit(aufgabe);

        Future<?> f1 = service.submit(aufgabe); // Runnable: liefert kein Ergebnis
        Future<Integer> f2 = service.submit(aufgabe2); // Callable: liefert eine Ergebnis

        service.shutdown();

        System.out.println("ENDE");
    }
}
