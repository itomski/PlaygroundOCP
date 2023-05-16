package de.lubowiecki.oca.playground.generics;

public class GenericBoxTest {

    public static void main(String[] args) {

        GenericBox<Integer> zahl = new GenericBox<>(100);
        System.out.println(zahl);
        System.out.println(zahl.getContent());
        System.out.println(100 + zahl.getContent());

        System.out.println();

        GenericBox<Double> zahl2 = new GenericBox<>(100d);
        System.out.println(zahl2);
        System.out.println(zahl2.getContent());
        System.out.println(100 + zahl2.getContent());

        System.out.println();

        GenericBox<String> wort = new GenericBox<>("Bla bla bla");
        System.out.println(wort); // toString wird automatisch benutzt
        System.out.println(wort.getContent());
        System.out.println(100 + wort.getContent());

        System.out.println();

        System.out.println(zahl.equals(zahl2));


    }
}
