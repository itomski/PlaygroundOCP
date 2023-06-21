package de.lubowiecki.oca.playground.threads;

public class ThreadTest1 {

    public static void main(String[] args) {

        machWas();

        // Ein neuer Thread wird erzeugt und mit einer Aufgabe belegt
        Thread t1 = new Thread(() -> {
            for(int i = 0;  i < 10_000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        t1.start(); // Damit er läuft, muss er gestartet werden

        Thread t2 = new Thread(() -> {
            for(int i = 0;  i < 10_000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        t2.start();
        // t2.start(); // Exception: Thread ist bereits gestartet

        Thread t3 = new Thread(() -> {
            for(int i = 0;  i < 10_000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        t3.start(); // run-Methode wird als extra-Prozess gestartet

        Thread t4 = new Thread();
        t4.start(); // run Methode ist leer, daher macht der Thread nichts

        for(int i = 0;  i < 10_000; i++) {

            // Thread.currentThread: liefert den Thread, der gerade ausgeführt wird
            System.out.println(Thread.currentThread().getName() + ": " + i);

        }
    }

    public static void machWas() {
        System.out.println(Thread.currentThread().getName() + ": machWas");
    }
}
