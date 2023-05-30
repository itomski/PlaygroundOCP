package de.lubowiecki.oca.playground.collections;

import java.util.*;

public class SetTest1 {

    public static void main(String[] args) {

        //Set<String> namen = new HashSet<>();
        Set<String> namen = new HashSet<>(Set.of("Peter", "Carol", "Bruce", "Natasha"));
        namen.add("Peter");
        System.out.println(namen);

        System.out.println();

        Set<Person> personen = new HashSet<>();
        Person p1 = new Person("Peter", "Parker");
        personen.add(p1);
        Person p2 = new Person("Peter", "Parker");
        personen.add(p2);
        Person p3 = new Person("Carol", "Danvers");
        personen.add(p3);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        System.out.println(personen);

        System.out.println();

        // Comparator = Vergleichsobjekt
        Comparator<Person> comp = (a, b) -> a.getLastname().compareToIgnoreCase(b.getLastname());

        //Set<Person> personen2 = new TreeSet<>(); // Es wird die compareTo-Methode der Objekte zum Sortieren verwendet. Natürliche Reihenfolge
        Set<Person> personen2 = new TreeSet<>(comp); // Es wird der Comparator zum Sortieren verwendet. Künstliche Reihenfolge
        personen2.add(p1);
        personen2.add(p3);
        personen2.add(new Person("Bruce", "Banner"));
        personen2.add(new Person("Bruce", "Johnson"));

        System.out.println(personen2);

        System.out.println();

        Set<Integer> zahlen = new TreeSet<>();
        zahlen.add(7);
        zahlen.add(5);
        zahlen.add(12);
        zahlen.add(22);
        zahlen.add(8);
        zahlen.add(1);
        zahlen.add(10);
        zahlen.add(9);
        zahlen.add(22);
        System.out.println(zahlen);

        SortedSet<Integer> zahlen2 = (SortedSet<Integer>) zahlen;

        System.out.println();

        // Views aus Ausschnitte des Original-Sets

        Set<Integer> anfang = zahlen2.headSet(10); // von Anfang bis 10
        System.out.println(anfang);

        Set<Integer> ende = zahlen2.tailSet(10); // von 10 bis Ende
        System.out.println(ende);

        Set<Integer> sub = zahlen2.subSet(5, 15); // von 5 bis 15
        System.out.println(sub);

        System.out.println();

        zahlen.add(17);
        zahlen.add(2);
        sub.add(13);
        //sub.add(18); // Exception: Zahl ist out of range

        System.out.println(anfang);
        System.out.println(ende);
        System.out.println(sub);

        System.out.println();

        Set<String> namen3 = new LinkedHashSet<>();
        // Set<String> namen3 = new HashSet<>();
        namen3.add("Peter");
        namen3.add("Bruce");
        namen3.add("Natasha");
        namen3.add("Steve");
        System.out.println(namen3);

        System.out.println();

        NavigableSet<Integer> zahlen4 = (NavigableSet<Integer>) zahlen2;

        System.out.println(zahlen4);
        System.out.println(zahlen4.ceiling(5));
        System.out.println(zahlen4.ceiling(4)); // da 4 nicht da ist, wird das nächste vorhandene Element geliefert
        System.out.println(zahlen4.floor(5));
        System.out.println(zahlen4.floor(4)); // da 4 nicht da ist, wird das nächst-kleinere Element geliefert

        System.out.println(zahlen4.lower(5)); // vorheriges Element
        System.out.println(zahlen4.higher(5)); // nächstes Element
    }
}
