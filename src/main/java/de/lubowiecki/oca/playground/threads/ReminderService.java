package de.lubowiecki.oca.playground.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderService {

    public static void main(String[] args) {

        Runnable reminder = () -> {
            System.out.println("Check your mails!");
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        // service.schedule(reminder, 10, TimeUnit.SECONDS); // Einmalige ausführung nach 10 Sekunden
        //service.scheduleAtFixedRate(reminder, 0, 5, TimeUnit.SECONDS); // Startet ohne Vestarz alle 5 Sekunden

        // Startet ohne Vestarz jewils 5 Sekunden nach Beendigung der vorhergehenden Aufgabe
        service.scheduleWithFixedDelay(reminder, 0, 5, TimeUnit.SECONDS);
    }
}
