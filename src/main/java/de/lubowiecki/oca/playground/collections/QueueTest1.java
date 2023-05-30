package de.lubowiecki.oca.playground.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest1 {

    public static void main(String[] args) {

        Queue<Integer> ints = new LinkedList<>();
        ints.add(2);
        ints.add(5);
        ints.offer(7);
        ints.offer(19);
        ints.add(22);

        for(int z : ints) {
            System.out.println(z);
        }

        System.out.println(ints);

        System.out.println();

        while(!ints.isEmpty()) {
            System.out.println(ints.poll()); // poll entfernt ein Element am Anfang der Warteschlange
        }

        System.out.println(ints);

        // FIFO - first in first out
        // LIFO - last in first out

        Deque<Integer> zahlen2 = (Deque<Integer>) ints;

        zahlen2.push(17); // auf den Stack legen
        System.out.println(zahlen2.pop()); // vom Stack entfernen

        Queue<String> namen = new ArrayDeque<>(3);
        System.out.println(namen.offer("A"));
        System.out.println(namen.offer("B"));
        System.out.println(namen.offer("C"));
        System.out.println(namen.offer("D")); // Array wird vergößert
    }
}
