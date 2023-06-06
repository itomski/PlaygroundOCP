package de.lubowiecki.oca.playground.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.stream.DoubleStream;

public class MethodenReferenzTest {

    public static void main(String[] args) {

        List<String> namen = new ArrayList<>(List.of("Max", "Peter", "Anna", "Carol", "Bruce"));

        // Consumer<String>: void accept(T t)
        namen.forEach(n -> System.out.println(n + "#"));
        // void println(String s)
        namen.forEach(System.out::println); // println hat den gleichen eingangs und rückgabetyp wie ein Consumer

        // Methoden-Referenzen sind verweise auf bereits vorhandene Methode, die gleiche eingangs und rückgabetyp haben

        namen.forEach(MethodenReferenzTest::machWasStatic); // Static - es wird geprüft, ob die Methode ein String nimmt und void zurückliefert

        MethodenReferenzTest mrt = new MethodenReferenzTest();
        namen.forEach(mrt::machWasInstanz); // Instanz - es wird geprüft, ob die Methode ein String nimmt und void zurückliefert

        //Math.random()

        DoubleSupplier ds = () -> Math.random();
        // DoubleStream.generate(ds);
        // DoubleStream.generate(Math::random);
    }

    void machWasInstanz(String s) {
    }

    static void machWasStatic(String s) {
    }
}
