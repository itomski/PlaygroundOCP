package de.lubowiecki.oca.playground.lambdas;

import java.util.OptionalInt;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class PrimitiveFuncInterfaces {

    public static void main(String[] args) {

        IntSupplier sup = () -> 1;
        System.out.println(sup.getAsInt()); // ist der return primitiv hängt man ein As... dran
        // IntStream.generate(sup)

        Supplier<Double> dSup = () -> 1.0;
        System.out.println(dSup.get()); // ist der return komplex wird kein As... dran gehängt

        IntFunction<Double> iFunc = w -> w * 1.0;
        System.out.println(iFunc.apply(10)); // Rückgabetyp ist komplex kein As... dran

        ToIntFunction<Double> func2 = w -> w.intValue();
        System.out.println(func2.applyAsInt(10.0)); // Rückgabetyp ist primitiv daher As... dran

        Random rand = new Random();
        IntSupplier W6 = () -> rand.nextInt(1000) + 1;

        OptionalInt opt = IntStream.generate(W6).limit(100).distinct().max();
        opt.ifPresent(w -> System.out.println(w));
    }

}
