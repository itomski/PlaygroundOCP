package de.lubowiecki.oca.playground.threads;

public class WaitNotifyTest {
    
    private final Object LOCK1 = "ABCD";

    public static void main(String[] args) {
        new WaitNotifyTest().go();
    }

    private void go() {

        new Thread(() -> {

            System.out.println("A1: start");

            synchronized (LOCK1) {
                System.out.println("A1: wartet");
                try {
                    LOCK1.wait(); // Der aktuelle Thread trägt sich in das LOCK1 als wartend ein und gibt den LOCK1 frei
                }
                    catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("A1: fertig");

        }).start();

        new Thread(() -> {

            System.out.println("A2: start");

            synchronized (LOCK1) {
                System.out.println("A2: wartet");
                try {
                    LOCK1.wait(); // Der aktuelle Thread trägt sich in das LOCK1 als wartend ein und gibt den LOCK1 frei
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("A2: fertig");

        }).start();

        new Thread(() -> {

            System.out.println("A3: start");

            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (LOCK1) {
                System.out.println("A3: weckt die anderen auf!");
                // LOCK1.notify(); // Ein wartender Thread wird benachrichtigt, dass er weiter machen kann
                LOCK1.notifyAll(); // Alle wartenden Threads werden benachrichtigt, dass sie weiter machen kann
            }

            System.out.println("A3: fertig");

        }).start();
    }
}
