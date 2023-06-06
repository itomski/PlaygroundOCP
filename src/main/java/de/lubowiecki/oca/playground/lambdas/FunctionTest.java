package de.lubowiecki.oca.playground.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionTest {

    public static void main(String[] args) {

        List<Double> zahlen = new ArrayList<>(List.of(1.0,5.0,27.99,18.15,6.0,19.22,22.99,1000.0,109.2,22.17));

        // Formatierung
        // Function<T,R>: R apply(T t)
        Function<Double, String> fmtPrice = (t) -> String.format("%.2f", t);

        System.out.println(fmtPrice.apply(10.0));
        System.out.println(fmtPrice.apply(15.12345));
        System.out.println(fmtPrice.apply(.0));

        System.out.println();

        // Stream ist eine Kette von Werten (seit Java 1.8)
        zahlen.stream().map(fmtPrice).forEach(w -> System.out.println(w));

        System.out.println();

        List<Double> doubleList = change(List.of(10, 15, 22, 7));
        System.out.println(doubleList);

        Function<Integer, Double> f1 = i -> i * i * 1.0;
        Function<Integer, Double> f2 = i -> i * 0.5;
        Function<Double, Double> f3 = i -> i / 7.0;

        doubleList = change(List.of(10, 15, 22, 7), f2);
        System.out.println(doubleList);

        doubleList = change(List.of(10, 15, 22, 7), f1.andThen(f3)); // Zwei Funktionen werden zu einer kombiniert
        // compose führt die Methoden in umgekehrter Reihenfolge aus
        System.out.println(doubleList);

        // IntFunction<R> : primitiv int wird zu R umgewandelt
        // IntToDoubleFunction : primitiv int wird zu primitiv double umgewandelt
        // ToIntFunction<T> : Generischer Typ wird zu primitiv int umgewandelt

        System.out.println();

        zahlen = new ArrayList<>(List.of(1.0,5.0,27.99,18.15,6.0,19.22,22.99,1000.0,109.2,22.17));

        // UnaryOperator<Double> ist das gleiche wie Function<Double, Double>
        // Function<Double, Double> : R apply(T t)
        // UnaryOperator<Double> : T apply(T t)
        UnaryOperator<Double> uo = w -> w * 2;
        System.out.println(zahlen);
        zahlen.replaceAll(uo);
        System.out.println(zahlen);

    }

    private static List<Double> change(List<Integer> ints) {
        List<Double> doubles = new ArrayList<>();
        for(int i : ints) {
            doubles.add(i * 5.0);
        }
        return doubles;
    }

    private static List<Double> change(List<Integer> ints, Function<Integer, Double> func) {
        List<Double> doubles = new ArrayList<>();
        for(int i : ints) {
            doubles.add(func.apply(i));
        }
        return doubles;
    }
}
