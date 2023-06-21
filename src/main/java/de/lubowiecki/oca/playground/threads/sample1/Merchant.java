package de.lubowiecki.oca.playground.threads.sample1;

public class Merchant implements Runnable {

        private final Storage storage;

        private final String name;

        public Merchant(String name, Storage storage) {
            this.storage = storage;
            this.name = name;
        }

        @Override
        public void run() {

            while(true) {

                synchronized(storage) {
                    System.out.println(name + " will Holz entnehmen.");

                    try {
                        storage.get();
                        System.out.println(name + " hat erfolgreich Holz abgeholt. Füllstand: " + storage.getFillLevel());
                    } catch (RuntimeException e) {
                        System.out.println(name + " konnte das Holz nicht abholen, da das Lager leer ist.");
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