package de.lubowiecki.oca.playground.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        List<Integer> zahlen = new ArrayList<>();
        zahlen.add(10);
        zahlen.add(15);
        zahlen.add(22);
        System.out.println(zahlen.get(2)); // Wahlfreier-Zugriff

        zahlen = new LinkedList<>(zahlen); // Wechsel von ArrayList auf LinkedList
        zahlen.add(1,28);
        zahlen.add(0,7);
        zahlen.add(4,18);

        zahlen = new ArrayList<>(zahlen); // Wechsel von LinkedList auf ArrayList

        System.out.println(zahlen);
        Collections.sort(zahlen);
        System.out.println(zahlen);

    }

}
