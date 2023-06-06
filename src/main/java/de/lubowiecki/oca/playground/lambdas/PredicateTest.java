package de.lubowiecki.oca.playground.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        List<Double> zahlen = new ArrayList<>(List.of(1.0,5.0,27.99,18.15,6.0,19.22,22.99,1000.0,109.2,22.17));

        Predicate<Double> pred = w -> w < 50;
        //zahlen.removeIf(pred); // Alle Werte die kleiner als 50 sind werden entfernt
        //zahlen.removeIf(pred.negate()); // negate: dreht die behauptung um
        zahlen.removeIf(pred.or(w -> w > 200)); // and und or: verbindet zwei predicates

        System.out.println(zahlen);

        // IntPredicate
        // LongPredicate
        // DoublePredicate
    }
}
