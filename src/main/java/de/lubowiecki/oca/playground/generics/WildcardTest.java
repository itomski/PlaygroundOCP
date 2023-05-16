package de.lubowiecki.oca.playground.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest<T> {

    List<T> list1 = new ArrayList<>();

    List<?> list2 = new ArrayList<>();

    List<? extends Number> list3 = new ArrayList<>();

    public static void main(String[] args) {

        WildcardTest<String> str = new WildcardTest<>();
        str.list1 = new ArrayList<>(); // Muss eine List von String sein
        str.list2 = new ArrayList<>(); // Kann eine List von String sein, muss es aber nicht
        str.list2 = List.of(1,2,3,4); // Kann auch eine List von anderen Typen sein

        WildcardTest<Integer> ints = new WildcardTest<>();
        ints.list1 = new ArrayList<>(); // Muss eine List von Integer sein
        ints.list2 = List.of("A", "B");

        System.out.println();

        WildcardTest<Double> doubles = new WildcardTest<>();
        //doubles.list3 = List.of(10.0, 20.12, 19.99);
        doubles.list3 = List.of(10, 7, 18, 99);
        System.out.println(doubles.sum());
    }

    double sum() {
        double sum = 0;
        for(Number d : list3) {
            sum += d.doubleValue();
        }
        return sum;
    }
}
