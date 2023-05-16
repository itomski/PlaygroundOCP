package de.lubowiecki.oca.playground.generics;

import java.util.ArrayList;
import java.util.List;

public class FlughafenTest {

    public static void main(String[] args) {

        Flughafen<A365> flughafen = new Flughafen<>();

        A365 a = new A365();
        flughafen.landen(a);
        flughafen.starten(a);

        UFO u = new UFO();
        //Flughafen<UFO> flughafen2 = new Flughafen<>();
    }
}

class Flughafen<T extends TowerKommunikation & Landbar & Startbar> {

    private List<T> flugobjekte = new ArrayList<>();

    public boolean landen(T flugobjekt) {
        flugobjekt.landeErlaubnisAnfordern();
        flugobjekt.fahrwerkAusfahren();
        flugobjekt.landen();
        return flugobjekte.add(flugobjekt);
    }

    public boolean starten(T flugobjekt) {
        flugobjekt.startErlaubnisAnfordern();
        flugobjekt.starten();
        flugobjekt.fahrwerkEinfahren();
        return flugobjekte.remove(flugobjekt);
    }
}

interface TowerKommunikation {

    boolean startErlaubnisAnfordern();

    boolean landeErlaubnisAnfordern();

    boolean problemMelden();
}

interface Landbar {

    boolean landen();

    boolean fahrwerkAusfahren();

}

interface Startbar {

    boolean starten();

    boolean fahrwerkEinfahren();

}

class A365 implements TowerKommunikation, Landbar, Startbar {

    @Override
    public boolean startErlaubnisAnfordern() {
        return false;
    }

    @Override
    public boolean landeErlaubnisAnfordern() {
        return false;
    }

    @Override
    public boolean problemMelden() {
        return false;
    }

    @Override
    public boolean landen() {
        return false;
    }

    @Override
    public boolean fahrwerkAusfahren() {
        return false;
    }

    @Override
    public boolean starten() {
        return false;
    }

    @Override
    public boolean fahrwerkEinfahren() {
        return false;
    }
}

class UFO implements Startbar, Landbar {

    @Override
    public boolean landen() {
        return false;
    }

    @Override
    public boolean fahrwerkAusfahren() {
        return false;
    }

    @Override
    public boolean starten() {
        return false;
    }

    @Override
    public boolean fahrwerkEinfahren() {
        return false;
    }
}