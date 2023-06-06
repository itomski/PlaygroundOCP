package de.lubowiecki.oca.playground.streams;

import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamStest2 {

    public static void main(String[] args) {

        Stream<Double> zahlen = Stream.of(10.0, 20.2, 10.7, 15.22, 19.15);

        // int 19 wird mit primitive widening zu zu primitiv double
        DoubleStream primitiveZahlen = DoubleStream.of(10.0, 20.2, 10.7, 15.22, 19);

        // Map verändert einen Wert
        // Function<T,R>
        Function<Double, String> func1 = v -> String.format("%.2f", v);
        Function<String, Double> func2 = v -> Double.parseDouble(v.replace(",", "."));
        //zahlen.map(func).sorted().forEach(v -> System.out.println(v));

        zahlen.map(func1)
                .peek(v -> System.out.print("#" + v))
                .map(func2)
                .peek(v -> System.out.print("@" + v)) // bietet die Möglichkeit den aktuellen Zustand zu sehen
                .map(d -> d.intValue())
                .forEach(v -> System.out.println("!" + v));

    }
}
