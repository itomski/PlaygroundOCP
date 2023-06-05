package de.lubowiecki.oca.playground.lambdas;

public class LambdaTest2 {

    private static int r = 200;

    public static void main(String[] args) {

        // Lambda wird definiert
        Fahrbar f1 = createFahrbar();



        // Lambda wird verwendet
        f1.fahreLos(20);

        r = 500; // Ändert den Zustand des Lambdas

        f1.fahreLos(20);

    }

    public static Fahrbar createFahrbar() {

        int y = 5; // Variable muss final oder effektiv final sein!
        final int z = 10;

        // Lambda wird definiert
        Fahrbar f = (s) -> System.out.println("Fahre los mit " + (s * y * z * r) + " km/h");

        // y = 10; // Variable wäre nicht mehr effektiv final
        // z = 100; // Fehler! Variable ist final! Kann nicht geändert werden
        // r ist eine Klassenvariable und kann nachträglich verändert werden!

        return f;
    }
}

@FunctionalInterface
interface Fahrbar {
    void fahreLos(int speed);
}
