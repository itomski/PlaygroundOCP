package de.lubowiecki.oca.playground.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest1 {

    public static void main(String[] args) {

        List<Integer> zahlen = new ArrayList<>(List.of(1,5,27,18,6,19,22,1000,109,22));

        // Consumer<Integer>: void accept(T t)
        zahlen.forEach(i -> System.out.print(i + ", "));

        System.out.println();

        Consumer<Integer> cons = a -> System.out.print(a + " \t");
        zahlen.forEach(cons);

        System.out.println();

        zahlen.forEach(x -> System.out.printf("%d... \t", x));

        System.out.println();

        //zahlen.forEach(null);

        cons.accept(1000000000);

        System.out.println();

        Consumer<Integer> cons1 = a -> {};
        zahlen.forEach(cons1);

        System.out.println("--------------------");

        Consumer<Integer> cons3 = w -> System.out.print("#" + w);
        Consumer<Integer> cons4 = w -> System.out.print("@");

        Consumer<Integer> cons5 = cons3.andThen(cons4); // Verbindet 2 Consumer zu einem
        zahlen.forEach(cons5);
        System.out.println();
        zahlen.forEach(cons4.andThen(cons3));

        System.out.println("--------------------");

        // Consumer für primitive Datentypen
        // IntConsumer
        // LongConsumer
        // DoubleConsumer

        // Generischer Typ wird nicht angegeben, da der Consumer schon auf primitiv int festgelegt ist
        IntConsumer icons1 = i -> {
            double d = i; // primitiv widening
            System.out.println(Math.pow(i, 5));
        };

        Consumer<Integer> icons2 = i -> {
            // Double d = i; // Komplex widening von Integer auf Double nicht möglich
            // System.out.println(d);
        };
    }

    void machWas(String s) {

    }
}
