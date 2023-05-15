package de.lubowiecki.oca.playground.basics;

import java.util.ArrayList;
import java.util.List;

public class Vererbung2 {

    public static void main(String[] args) {

        List<Movable> parkplatz = new ArrayList<>();
        parkplatz.add(new PKW());
        // parkplatz.add(new Transporter()); // Abstrakte Klassen dürfen nicht instanziert werden
        // parkplatz.add(123);
        // parkplatz.add("Hallo Welt");

    }
}

interface Movable {
    void fahre(int x, int y);
}

class PKW implements Movable {

    @Override
    public void fahre(int x, int y) {

    }
}

abstract class Transporter implements Movable {

}
