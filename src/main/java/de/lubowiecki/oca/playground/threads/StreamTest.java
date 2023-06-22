package de.lubowiecki.oca.playground.threads;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args) {

        Random rand = new Random();

        IntStream.generate(rand::nextInt)
                .parallel()
                .limit(1_000_000)
                .filter(i -> {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    return i > 5;
                })
                .forEach(i -> System.out.println(Thread.currentThread().getName() + ": " + i));
    }
}
