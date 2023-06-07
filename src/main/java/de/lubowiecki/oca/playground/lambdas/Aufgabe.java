package de.lubowiecki.oca.playground.lambdas;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aufgabe {

    public static void main(String[] args) {

        /*
        Schreibe 3 Lambda-Implementierungen für jedes der Interfaces
        1 x Wrapper
        1 x primitiv
        1 x anderen Komplexen (nicht Wrapper z.B. Person)

        Consumer
        Supplier
        Function
        UnaryOperator
        Predicate
        */

        Consumer<Double> cons1 = v -> System.out.println(v); // v ist komplex (Double)
        DoubleConsumer cons2 = v -> System.out.println(v); // v ist primitiv (double)
        Consumer<Fahrzeug> cons3 = v -> System.out.printf("| %-10s | %-10s | \n", v.getKennzeichen(), v.getKmStand()); // v ist komplex (Fahrzeug)

        List<Fahrzeug> fahrzeuge = new ArrayList<>();
        fahrzeuge.add(new Fahrzeug("B:AB 123", 2000, 120_000));
        fahrzeuge.add(new Fahrzeug("HH:XY 123", 1999, 180_000));
        fahrzeuge.add(new Fahrzeug("HB:AB 567", 2020, 23_500));

        // Consumer

        fahrzeuge.forEach(cons3);

        System.out.println();

        List.of(10.0, 22.10, 17.99).forEach(cons1); // Collections sind mit Wrappertypen gefüllt

        System.out.println();

        DoubleStream.generate(Math::random).limit(10).forEach(cons2); // Primitive Streams verlangt einen primitiven Consumer

        // Supplier

        Random rand = new Random();
        Supplier<Integer> sup1 = () -> rand.nextInt(10);  ; // Erzeugt einen Wrapper-Typ
        Stream<Integer> zahlen1 = Stream.generate(sup1); // Komplexe Streams verlange komplexe Supplier

        IntSupplier sup2 = () -> rand.nextInt(10);  ; // Erzeugt einen primitive Werte
        IntStream zahlen2 = IntStream.generate(sup2); // primitive Streams verlange primitive Supplier

        Supplier<Fahrzeug> sup3 = () -> new Fahrzeug("Unbekannt", Year.now().getValue(), 0);
        fahrzeuge = Stream.generate(sup3).limit(100).collect(Collectors.toList()); // collect sammelt die Werte eines Streams zu einem Collection

        System.out.println();

        fahrzeuge.forEach(cons3);

        System.out.println();

        // Function

        Function<Fahrzeug, Integer> func1 = f -> f.getBaujahr();
        fahrzeuge.stream().map(func1).distinct().forEach(System.out::println);

        System.out.println();

        fahrzeuge.get(2).setKennzeichen("HH:AB 123");
        fahrzeuge.get(10).setKennzeichen("HB:XY 225");

        Function<Fahrzeug, String> func2 = f -> f.getKennzeichen();
        fahrzeuge.stream().map(func2).distinct().forEach(System.out::println);

        System.out.println();

        // IntUnaryOperator: bleibt beim gleichen typ d.h. nimmt int entgegen und liefert int zurück
        // distinct entfernt Duplikate
        IntStream.of(1,7,22,18,19,3,100,25,99,18,3)
                .map(v -> v * 2)
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        Function<Double,Integer> func3 = d -> d.intValue();
        List.of(10.0, 22.10, 17.99).stream().map(func3).forEach(System.out::println);

        System.out.println();

        // Predicate

        // Entfernt Fahrzeuge aus der Liste wenn Predicate true ergibt
        //fahrzeuge.removeIf(f -> f.getKennzeichen().equals("Unbekannt"));
        //fahrzeuge.forEach(cons3);

        // Entfernt Fahrzeuge aus dem Stream wenn Predicate false ergibt
        // Liste wird nicht verändert!
        fahrzeuge.stream().filter(f -> !f.getKennzeichen().equals("Unbekannt")).forEach(cons3);

        System.out.println();

        // filter auf einem primitiven Stream verlangt auch ein primitives Predicate
        IntPredicate pred1 = v -> v > 100;
        IntPredicate pred2 = v -> v < 900;
        IntStream.generate(() -> rand.nextInt(1000))
                .filter(pred1.and(pred2))
                .limit(20)
                .forEach(System.out::println);

    }
}
