package de.lubowiecki.oca.playground.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOpsTest {

    public static void main(String[] args) {

        // forEach
        // collect: Sammelt die Werte des Stream zu einer Collection
        // reduce: Reduziert die Werte des Streams auf einen Wert
        // max, min: liefern das kleinste/größte Element. Bei komplexen Datentypen ist ein Comparator nötig
        // anyMatch, allMatch, noneMatch: Prüfen die Elemente eines Streams gegen ein Predicate
        // findFirst, findAny: Liefern den ersten Wert
        // für primitive min, max, sum, average

        Stream<Integer> zahlen = Stream.of(1,2,3,4,5,6,7,8,9,10);

        // zahlen.forEach(System.out::println);

        // System.out.println(zahlen.filter(v -> v > 10).findFirst()); // Leeres Optional, da filter alle Werte entfernt hat
        // System.out.println(zahlen.findFirst()); // enthält ein Optional mit dem ersten Wert
        // Für sequenzielle Streams machen findFirst und findAny das gleiche


        zahlen = Stream.iterate(0, i -> i + 2);

        // Standard: Streams sind squenziell
        // parallel: wechsel auf parallele Verarbeitung
        zahlen.limit(10)
                //.parallel() // stellt die komplette Verarbeitung des Streams auf parallel
                .forEach(v -> {
                    //System.out.print(Thread.currentThread().getName() + ": ");
                    System.out.print(v);
                    System.out.println();
                });

        System.out.println();
        zahlen = Stream.iterate(0, i -> i + 2).limit(10);
        //List<Integer> list = zahlen.collect(Collectors.toList());
        //System.out.println(list);

        //Set<Integer> set = zahlen.collect(Collectors.toSet());
        //System.out.println(set);

        // Supplier<TreeSet>: TreeSet::new
        TreeSet<Integer> set = zahlen.collect(TreeSet::new, Set::add, Set::addAll);
        // LinkedList<Integer> list = zahlen.collect(LinkedList::new, List::add, List::addAll);
        System.out.println(set);

        boolean ueber10 = List.of(1,5,7,22,18,1,100,250,7).stream()
                .mapToInt(i -> i)
                .allMatch(v -> v > 10);

        System.out.println(ueber10);


        IntStream.of(1,2,3,4,5).boxed(); // Ändert einen primitiven Stream auf ein Wrapper-Stream
    }
}
