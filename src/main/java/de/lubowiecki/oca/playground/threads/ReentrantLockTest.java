package de.lubowiecki.oca.playground.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        //final Object LOCK = new Object();
        final ReentrantLock LOCK = new ReentrantLock(true);


        Runnable aufgabe = () -> {
            String name = Thread.currentThread().getName();

            while(true) {
                /*
                synchronized (LOCK) {
                    System.out.println(name + ": Step 1");
                    System.out.println(name + ": Step 2");
                    System.out.println(name + ": Step 3");
                }
                */

                // Fair = der am längsten wartende kommt als nächstes dran
                // LOCK.lock();
                try {
                    if (LOCK.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println(name + ": Step 1");
                        System.out.println(name + ": Step 2");
                        System.out.println(name + ": Step 3");
                        LOCK.unlock();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(aufgabe).start();
        new Thread(aufgabe).start();
        new Thread(aufgabe).start();
        new Thread(aufgabe).start();
    }
}
