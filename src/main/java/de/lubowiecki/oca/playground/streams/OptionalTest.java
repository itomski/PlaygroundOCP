package de.lubowiecki.oca.playground.streams;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

    public static void main(String[] args) {

        Optional<String> opt = Optional.of("Peter");
        //opt = Optional.empty();

        //System.out.println(opt.get()); // Exception wenn leer
        System.out.println(opt.orElse("Leer"));

        Supplier<String> sup = () -> "...";
        System.out.println(opt.orElseGet(sup)); // Wenn kein Wert da ist, wird dieser mit dem Supplier gebaut

        // System.out.println(opt.orElseThrow()); // Wirft die Standard-Exceoption
        // System.out.println(opt.orElseThrow(() -> new RuntimeException("Dies und das"))); // Wirft eine Exception vom gewünschten Typ

        opt.ifPresent(System.out::println); // wird nur ausgeführt, wenn Wert verfügbar ist

        if(opt.isPresent())
            System.out.println(opt.get());

        System.out.println(opt.map(s -> s.toUpperCase()).get());

    }

}
