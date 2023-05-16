package de.lubowiecki.oca.playground.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GenericsStart {

    public static void main(String[] args) {

        List<String> namen = Arrays.asList("Peter", "Carol", "Natasha", "Bruce", "Steve"); // Fixed Size
        namen = new ArrayList<>(namen); // Kann die Größe verändern

        List<Integer> zahlen = new ArrayList<>(Arrays.asList(10,25,33,7,8,5));

        //  boolean test(T t);
        Predicate<String> pred = name -> name.startsWith("N");
        namen.removeIf(pred);

        System.out.println(namen);

    }
}
