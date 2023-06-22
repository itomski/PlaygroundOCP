package de.lubowiecki.oca.playground.threads.sample1;

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        Storage lager1 = new Storage(10);

        new Thread(new Lumberjack("Peter", lager1)).start(); // Producer
        new Thread(new Lumberjack("Carol", lager1)).start(); // Producer

        new Thread(new Merchant("Bruce", lager1)).start(); // Consumer
    }
}
