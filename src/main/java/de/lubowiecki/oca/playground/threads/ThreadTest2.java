package de.lubowiecki.oca.playground.threads;

import java.time.Duration;
import java.time.Instant;

public class ThreadTest2 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": start");
        Instant start = Instant.now();

        // Vor Java 1.8
        Runnable aufgabe1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;  i < 1_000_000; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        };

        Thread t1 = new Thread(aufgabe1);
        t1.start(); // startet die run-Methode parallel als eigenständigen Prozess
        //t1.run(); // wird vom main-Thread sekuenziell gestartet

        // Ab Java 1.8
        Runnable aufgabe2 = () -> {
            for(int i = 0;  i < 20; i++) {

                if(Thread.currentThread().isInterrupted()) // Prüft, ob sein Flag auf "Abgebrochen gesetzt ist"
                    break;

                // Kein direkter Zugriff auf das Thread objekt möglich
                // Umweg über Thread.currentThread() erforderlich
                System.out.println(Thread.currentThread().getName() + ": " + i);

                try {
                    Thread.sleep(2000); // Der Thread, der diese Zeile ausführt pausiert für 0,5 Sekunde
                }
                catch (InterruptedException e) {
                    // Wenn ein Thread während er in sleep oder wait Zustand ist abgebrochen wird
                    // Wird das Flag nicht gestzt, sondern erstmal nur ne Exception geworfen und der sleep/wait Zustand verlassen
                    Thread.currentThread().interrupt(); // Erst jetzt kann das Flag gestzt werden
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread(aufgabe2);
        t2.start();
        //t2.run();

        Thread t3 = new Aufgabe();
        t3.setName("Peter Parker");
        t3.setPriority(10);
        t3.start();
        //t3.run();


        try {
            // Der main Thread wartet, bis die anderen Threads ihre Aufgabe fertig haben
            // Immer wenn es bei Threads zur Wartezeiten kommt, muss eine InterruptedException behandelt werden
            t1.join(); // Der Thread, der diese Zeile ausführt (main) wartet bis t1 seine run-Methode beendet hat
            t3.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2); // Main Thread wartet 2 Sekunden
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt(); // Setzt das Flag im t2 auf "Abgebrochen"

        Instant ende = Instant.now();
        System.out.println(Duration.between(start, ende).toMillis());
        System.out.println(Thread.currentThread().getName() + ": ende");

    }
}

class Aufgabe extends Thread {

    @Override
    public void run() {
        for(int i = 0;  i < 1_000_000; i++) {
            // Direkter Zugriff auf das Thread Objekt möglich
            System.out.println(getName() + ": " + i);
        }
    }
}
