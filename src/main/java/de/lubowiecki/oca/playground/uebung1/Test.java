package de.lubowiecki.oca.playground.uebung1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        List<Integer> zahlen = List.of(2,5,7,19,1,18,22,5);
        CollectionToolBox<Integer> intToolBox = new CollectionToolBox<>();
        zahlen = intToolBox.toSortedList(zahlen);
        System.out.println(zahlen);

        System.out.println();

        Set<String> namen = Set.of("Peter", "Bruce", "Carol", "Natasha", "Steve");
        CollectionToolBox<String> strToolBox = new CollectionToolBox<>();
        List<String> namenList = strToolBox.toSortedList(namen);
        System.out.println(namenList);

        System.out.println();

        /*
        System.out.println("Hallo".compareTo("Hi"));
        System.out.println("Hi".compareTo("Hallo"));
        System.out.println("Hi".compareTo("Hi"));
        */

        List<Fahrzeug> fahrzeuge = new ArrayList<>();
        fahrzeuge.add(new Fahrzeug("HH:AB 123", 2015, 75));
        fahrzeuge.add(new Fahrzeug("HB:CD 567", 2000, 125));
        fahrzeuge.add(new Fahrzeug("B:EF 171", 2010, 25));
        fahrzeuge.add(new Fahrzeug("ROW:ZZ 897", 1999, 200));

        CollectionToolBox<Fahrzeug> fahrzeugToolBox = new CollectionToolBox<>();
        fahrzeuge = fahrzeugToolBox.toSortedList(fahrzeuge);
        System.out.println(fahrzeuge);
    }

}
