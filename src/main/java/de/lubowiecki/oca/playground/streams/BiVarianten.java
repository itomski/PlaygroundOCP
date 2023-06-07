package de.lubowiecki.oca.playground.streams;

import de.lubowiecki.oca.playground.lambdas.Fahrzeug;

import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BiVarianten {

    public static void main(String[] args) {

        BiFunction<String, Integer, Fahrzeug> createFahrzeug = (kennzeichen, km) -> {
            Fahrzeug f = new Fahrzeug(kennzeichen, Year.now().getValue(), km);
            return f;
        };

        Fahrzeug fahrzeug = createFahrzeug.apply("HH:AB123", 10_250);
        System.out.println(fahrzeug.getKennzeichen() + ", " + fahrzeug.getBaujahr() + ", " + fahrzeug.getKmStand());

        BinaryOperator<Double> multi = (d1, d2) -> d1 * d2;
        BinaryOperator<Double> div = (d1, d2) -> d1 / d2;
        BinaryOperator<Double> add = (d1, d2) -> d1 + d2;
        BinaryOperator<Double> sub = (d1, d2) -> d1 - d2;
        BinaryOperator<Double> mod = (d1, d2) -> d1 % d2;

        System.out.println(multi.apply(10.0, 20.0));

        System.out.println();
        runOp(10.0, 20.0, div);
        runOp(10.0, 30.0, add);
        runOp(15.0, 20.0, sub);
        runOp(10.0, 20.0, mod);

        // reduce: fasst die werte zu einem zusammen
        IntStream.iterate(1, i -> i + 5)
                .limit(100) // 1, 5, 10, 15, 20, 25 etc.
                .reduce((a, b) -> a + b) // (1, 5) > 6 + 10 > 16 + 15 > 31 + 20 > 51 + 25 etc
                .ifPresent(System.out::println);


        List<Double> list = List.of(10.0, 20.0, 30.0, 40.0);
        list.stream().collect(Collectors.toCollection(() -> new LinkedList<Double>()));

        Collector<Double, ?, List<Double>>  collector = Collectors.toCollection(() -> new LinkedList<>());

    }

    private static void runOp(Double a, Double b, BinaryOperator<Double> op) {
        System.out.println(op.apply(a, b));
    }
}
