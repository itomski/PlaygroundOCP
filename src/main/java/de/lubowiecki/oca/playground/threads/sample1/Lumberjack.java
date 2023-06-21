package de.lubowiecki.oca.playground.threads.sample1;

public class Lumberjack implements Runnable {

    private final Storage storage;

    private final String name;

    public Lumberjack(String name, Storage storage) {
        this.storage = storage;
        this.name = name;
    }

    @Override
    public void run() {

        while(true) {

            synchronized(storage) {
                System.out.println(name + " will Holz einlagern.");
                try {
                    storage.store(new Timber());
                    System.out.println(name + " hat erfolgreich Holz eingelagert. Füllstand: " + storage.getFillLevel());
                } catch (RuntimeException e) {
                    System.out.println(name + " konnte das Holz nicht einlagern, da das Lager voll ist.");
                }
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
