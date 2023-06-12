package de.lubowiecki.oca.playground.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ZahlenTest {

    public static void main(String[] args) {

        Stream<Integer> zahlen1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Bei komplexen Typen muss bei min und max ein Comparator vorgegeben werden
        // System.out.println(zahlen1.max((a, b) -> Integer.compare(a,b)));
        // System.out.println(zahlen1.min((a, b) -> Integer.compare(a,b))); // Stream ist bereits verbraucht
        // System.out.println(zahlen1.sum()); // sum gibt es für komplexe Datentypen nicht
        System.out.println(zahlen1.reduce((a, b) -> a + b)); // statt sum kann man reduce benutzen

        System.out.println();

        // SummaryStatistics gibt es nur für primitive Datentypen
        IntStream zahlen2 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = zahlen2.summaryStatistics();
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());
        System.out.println(stats.getCount());

        System.out.println();

        // Komplex zu primitiv
        zahlen1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        zahlen1.mapToInt(i -> i) // Wechsel von komplex auf primitiv
                .sum();

        zahlen2 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        zahlen2.boxed() // Wechsel von primitiv auf Wrapper (komplex)
                .findFirst();
        
    }
}
