package de.lubowiecki.oca.playground.lambdas;

import de.lubowiecki.oca.playground.jdbc.User;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierTest1 {
    public static void main(String[] args) {

        // Supplier<R>: R get()
        final Supplier<Integer> W6 = () -> (int)((Math.random() * 6) + 1);

        // produzieren primitive Werte, es wird kein generischer Typ vorgegeben
        // IntSupplier
        // DoubleSupplier
        // LongSupplier

        System.out.println(W6.get());
        System.out.println(W6.get());
        System.out.println(W6.get());
        System.out.println(W6.get());

        Supplier<User> userSupplier = () -> {
            User u = new User();
            String[] vornamen = {"Peter", "Bruce", "Steve", "Natasha", "Carol", "Tony"};
            String[] nachnamen = {"Parker", "Banner", "Rogers", "Romanov", "Danvers", "Stark"};
            u.setFirstname(vornamen[W6.get() - 1]);
            u.setLastname(nachnamen[W6.get() - 1]);
            return u;
        };

        User u1 = userSupplier.get();
        System.out.println(u1.getFirstname() + " " + u1.getLastname());

        System.out.println();

        Stream<Integer> stream = Stream.generate(W6);
        stream.forEach(w -> System.out.println(w));



    }

}
