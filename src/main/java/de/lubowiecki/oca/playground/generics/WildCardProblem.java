package de.lubowiecki.oca.playground.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class WildCardProblem {

    public static void main(String[] args) {

        List<Integer> zahlen = List.of(1,2,3,4,5,6,7,8,9);

        List<Integer> zahlen1 = new ArrayList<Integer>();
        //zahlen1 = new LinkedList<Double>(); // Error


        List<?> zahlen2 = new ArrayList<Integer>();
        zahlen2 = new LinkedList<Double>();
        zahlen2 = new LinkedList<String>();

        List<? extends Number> zahlen3 = new ArrayList<Integer>(zahlen);

        for(Number n : zahlen3) {
            System.out.println(n);
        }

        // Number n = 10;
        // zahlen3.add(n); // Bei Verwendung von Wildcards ist ein add nicht mehr möglich (Ausnahme: super)

        zahlen3 = new LinkedList<Double>();
        // zahlen3 = new LinkedList<String>(); // Error



    }

    /*
    static <T extends Number> double sum(Collection<T> zahlen) {
        double sum = 0;
        for(Number n : zahlen) {
            sum += n.doubleValue();
        }
        return sum;
    }
    */

    static double sum(Collection<? extends Number> zahlen) {
        double sum = 0;
        for(Number n : zahlen) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
