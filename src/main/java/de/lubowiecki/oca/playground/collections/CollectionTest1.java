package de.lubowiecki.oca.playground.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTest1 {

    public static void main(String[] args) {

        // ArrayList IS-A List IS-A Collection
        Collection<String> sammlung = new ArrayList<>();
        sammlung.add("Peter");
        sammlung.addAll(List.of("Bruce", "Steve", "Natasha", "Tony"));
        System.out.println(sammlung); // toString

        System.out.println("Steve? " + sammlung.contains("Steve"));
        System.out.println("Carol und Natasha? " + sammlung.containsAll(List.of("Carol", "Natasha")));

        // Seit Java 1.8
        sammlung.removeIf(n -> n.startsWith("N"));
        System.out.println(sammlung);

        System.out.println();

        // Seit Java 1.8
        sammlung.forEach(n -> System.out.println(n));

        System.out.println();

        for(String n : sammlung)
            System.out.println(n);

        // Nur für Listen Nutzbar. Nur Listen arbeiten mit einem Index
        // for(int i = 0; i < sammlung.size(); i++)
        //    System.out.println(sammlung.get(i));

        System.out.println();

        // Iterations-Objekt
        Iterator<String> itr = sammlung.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
