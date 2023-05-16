package de.lubowiecki.oca.playground.generics;

public class CalcTest {

    public static void main(String[] args) {

        GenericCalculator<Integer> calc1 = new GenericCalculator<>();
        System.out.println(calc1.add(10, 20));
        System.out.println(calc1.sub(10, 20));

        GenericCalculator<Float> calc2 = new GenericCalculator<>();
        System.out.println(calc2.add(10f, 20f));
        System.out.println(calc2.sub(10f, 20f));

        //GenericCalculator<String> calc3 = new GenericCalculator<>();
    }
}
