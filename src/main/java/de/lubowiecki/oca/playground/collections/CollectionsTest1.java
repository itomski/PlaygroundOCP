package de.lubowiecki.oca.playground.collections;

import java.util.*;

public class CollectionsTest1 {

    public static void main(String[] args) {


        List<String> l = Collections.EMPTY_LIST;

        //Set<String> namen = Collections.EMPTY_SET; // Nicht veränderbar
        Set<String> namen = new HashSet<>();
        Collections.addAll(namen, "Peter", "Bruce", "Anna", "Steve");
        System.out.println(namen);

        Queue<String> namen2 = new LinkedList<>(namen);
        namen2.offer("Steve");
        namen2.offer("Natasha");
        System.out.println(namen2);
        System.out.println(namen2.poll());
        System.out.println(namen2.poll());
        System.out.println(namen2);

        System.out.println();
        // als Stack
        namen2 = Collections.asLifoQueue((Deque<String>) namen2);
        namen2.offer("Bob");
        namen2.offer("Hans");
        System.out.println(namen2);
        System.out.println(namen2.poll());
        System.out.println(namen2.poll());
        System.out.println(namen2);

        // Collections.binarySearch(list, "Bob");
        //Collections.fill()

        List<Integer> zahlen = new ArrayList<>(List.of(2,3,5,8,19,22));
        zahlen.add(10); // Veränderbar

        zahlen = Collections.unmodifiableList(zahlen);
        zahlen.add(100); // Nicht mehr veränderbar

    }
}
