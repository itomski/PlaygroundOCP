package de.lubowiecki.oca.playground.threads;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class InvoikeTest {

    public static void main(String[] args) {

        Random rand = new Random();

        Callable<Integer> W6 = () -> rand.nextInt(6) + 1;
        Callable<Integer> W10 = () -> rand.nextInt(10) + 1;
        Callable<Integer> W20 = () -> rand.nextInt(20) + 1;
        Callable<Integer> W100 = () -> rand.nextInt(100) + 1;

        List<Callable<Integer>> aufgabenListe = List.of(W6, W6, W10, W20, W20, W20, W100, W6);

        ExecutorService service = Executors.newSingleThreadExecutor(); // Ein WorkerThread
        service = Executors.newFixedThreadPool(5); // 5 WorkerThreads
        service = Executors.newCachedThreadPool(); // So viele Threads wie Aufgaben

        try {
            /*
            List<Future<Integer>> futureList = service.invokeAll(aufgabenListe);

            futureList.forEach(f -> {
                try {
                    System.out.println(f.get());
                }
                catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
            */

            Integer wert = service.invokeAny(aufgabenListe);
            System.out.println(wert); // Es wird der Wert geliefert, der am schnellsten ermittelt wurde, Rest wird abgebrocheny

        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
