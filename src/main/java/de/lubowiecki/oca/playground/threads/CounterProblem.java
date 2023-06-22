package de.lubowiecki.oca.playground.threads;

import java.util.List;
import java.util.Vector;

public class CounterProblem {

    public static void main(String[] args) {


        //CounterBox box1 = new CounterBox();

        String lock = "A";

        CounterBox box1 = new CounterLockBox(lock);
        CounterBox box2 = new CounterLockBox(lock);
        Thread t1 = new Thread(new Counter(box1));
        Thread t2 = new Thread(new Counter(box2));

        //CounterBox box2 = new CounterBox();
        CounterBox box3 = new CounterLockBox(lock);
        Thread t3 = new Thread(new Counter(box3));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(box1.getCount());
        System.out.println(box2.getCount());

        Vector<String> vector; // Threadsave
        List<String> list; // NICHT Threadsave

        StringBuilder sb1; // NICHT Threadsave
        StringBuffer sb2; // Threadsave
    }
}

class Counter implements Runnable {

    private CounterBox box;

    public Counter(CounterBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100_000; i++) {
            box.up();
            box.down();
        }
    }
}

class CounterBox {

    private int count = 0;

    /*
    public void up() {
        synchronized (this) {
            count += 1;
        }
    }

    public void up() {
        synchronized (CounterBox.class) {
            count += 1;
        }
    }
    */

    public synchronized void up() {
        count += 1;
    }

    /*
    public void down() {
        synchronized (this) {
            count -= 1;
        }
    }
    */

    public synchronized void down() {
        count -= 1;
    }

    public int getCount() {
        return count;
    }
}

class CounterLockBox extends CounterBox {

    private int count = 0;
    private final Object LOCK;

    public CounterLockBox(Object LOCK) {
        this.LOCK = LOCK;
    }

    public void up() {
        // Der LOCK wird geholt
        // Ist der LOCK gerade durch einen anderen Thread in Verwendung, blockiert der Thread, bis er den LOCK bekommt
        synchronized (LOCK) {
            count += 1;
        }
    }

    public void down() {
        synchronized (LOCK) {
            count -= 1;
        }
    }

    public int getCount() {
        return count;
    }
}