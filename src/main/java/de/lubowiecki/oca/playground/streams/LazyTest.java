package de.lubowiecki.oca.playground.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LazyTest {

    public static void main(String[] args) {

        Stream<String> towns = Stream.of("Hamburg", "München", "Münster", "Kiel", "Bremen");

        towns = towns.filter(t -> {
                    System.out.println("f: " + t);
                    return !t.startsWith("K");
                })
                .map(t -> {
                    System.out.println("m: " + t);
                    return t.toUpperCase();
                });

        System.out.println("-----------");

        // Erst bei Verwendung einer Terminal-Operation werden auch die Intermediate-Operationen verwendet
        towns.forEach(t -> {
            System.out.println("e: " + t);
        });

        System.out.println();

        towns = Stream.of("Hamburg", "München", "Münster", "Kiel", "Bremen");
        // Verschachtelte Streams werden auf eine Ebene reduziert
        towns.flatMap(t -> Stream.of(t.split(""))).forEach(System.out::println);

        List<Kunde> kunden = new ArrayList<>();
        kunden.add(new Kunde("Peter"));
        kunden.add(new Kunde("Carol"));
        kunden.add(new Kunde("Bruce"));

        kunden.get(0).addProdukte(new Produkt("Handschuhe", 10.99));
        kunden.get(0).addProdukte(new Produkt("Mütze", 17.99));
        kunden.get(1).addProdukte(new Produkt("Tasse (rot)", 3.99));
        kunden.get(2).addProdukte(new Produkt("Tasse (gelb)", 3.99));


        kunden.stream()
                .flatMap(k -> k.getProdukte().stream()) // Liest für jeden Kunden die Produkte aus und liefert ein Stream aller Produkte zurück
                .sorted()
                .forEach(p -> System.out.println(p.getName() + ": " + p.getPreis()));


    }
}

class Kunde {

    private String name;
    private List<Produkt> produkte = new ArrayList<>();

    public Kunde(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    public void addProdukte(Produkt produkte) {
        this.produkte.add(produkte);
    }
}

class Produkt implements Comparable<Produkt> {
    private String name;
    private double preis;

    public Produkt(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public int compareTo(Produkt other) {
        return Double.compare(this.getPreis(), other.getPreis());
    }
}
