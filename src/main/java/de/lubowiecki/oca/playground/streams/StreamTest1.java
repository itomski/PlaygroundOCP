package de.lubowiecki.oca.playground.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {

        Stream<String> namen = Stream.of("Peter", "Bruce", "Carol", "Anna", "Tony");
        // Terminal-Operationen sind Verbraucher
        namen.forEach(System.out::println); // forEach ist eine Terminal-Operation

        System.out.println();

        // Stream kann nicht noch ein zweites mal verbraucht werden!
        // namen.forEach(v -> System.out.println(v));

        List<String> namenList = List.of("Peter", "Bruce", "Carol", "Anna", "Tony");
        // Stream wird auf Basis einer Liste erzeugt
        namenList.stream().forEach(System.out::println); // stream wird aus der Collection erstellt

        System.out.println();

        // Ein neuer Stream wird aus der gleichen Collection erstellt
        //namenList.stream().forEach(System.out::println); // Stream wird neu erstellt

        Integer[] zahlen = {1,2,3,4,5,6,7,8,9,10};
        // Stream wird aus einem Array erstellt
        Arrays.stream(zahlen).forEach(System.out::println);

        System.out.println();

        Random rand = new Random();
        // Der Stream wird mit dem Supplier befüllt und (ist unendlich, wenn nicht limitiert wird)
        IntStream.generate(() -> rand.nextInt()).limit(100).forEach(System.out::println);

        System.out.println();

        IntStream.iterate(0, i -> i + 2).limit(100).forEach(System.out::println);

        try {
            // Stream wird aus dem Inhalt einer Datei erstellt
            Stream<String> lines = Files.lines(Paths.get("data.txt"));
            // Inhalt wird Zeile für Zeile geholt und verarbeitet
            lines.forEach(l -> System.out.println(l.toLowerCase() + "\n"));

            //Files.lines(Paths.get("data.txt")).forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
