package de.lubowiecki.oca.playground.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadLockTest {

    public static void main(String[] args) {

        final Object LOCK1 = new Object();
        final Object LOCK2 = new Object();

        Runnable aufgabe1 = () -> {
            while(true) {
                synchronized (LOCK1) {
                    synchronized (LOCK2) {
                        System.out.println("AUSGABE A1");
                    }
                }
            }
        };

        Runnable aufgabe2 = () -> {
            while(true) {
                synchronized (LOCK2) {
                    synchronized (LOCK1) {
                        System.out.println("AUSGABE A2");
                    }
                }
            }
        };

        // Lösung die DeadLock = Locks in gleicher Reihenfolge aufnehmen

        new Thread(aufgabe1).start();
        new Thread(aufgabe2).start();

        try {
            Thread.sleep(2500);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
        long[] ids = tmx.findDeadlockedThreads();

        for(long id : ids) {
            System.out.println(tmx.getThreadInfo(id));
        }
    }
}
