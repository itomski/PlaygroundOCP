package de.lubowiecki.oca.playground.uebung.cal;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    private Kalender kalender;

    private final Scanner scanner = new Scanner(System.in);

    private App() {
        try {
            kalender = new Kalender();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Probleme beim Starten der App!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new App().start(); // Wechsel von Static- auf Instanz-Kontext
    }

    private void start() {

        Termin termin = new Termin();
        System.out.print("\nDatum: ");
        termin.setDatum(LocalDate.parse(scanner.nextLine())); // Validierung
        System.out.print("\nUhrzeit: ");
        termin.setZeit(LocalTime.parse(scanner.nextLine())); // Validierung
        System.out.print("\nTitel: ");
        termin.setTitel(scanner.nextLine());
        System.out.print("\nBemerkung: ");
        termin.setBemerkung(scanner.nextLine());

        try {
            kalender.add(termin); // Aktuelle Stand der Termine wird in die Datei geschrieben
            System.out.println("\nTermin wurde gespeichert.");
        }
        catch(IOException e) {
            e.printStackTrace(); // TODO: Ausgabe optimieren
        }

        System.out.println("----------------------------------");

        // getAll liefert eine Map, die Tag für Tag durchlaufen wird
        // v ist das Set von Termin-Objekten für einen bestimmten Tag
        kalender.getAll().forEach((k, v) -> v.forEach(t -> System.out.println(t) /* Jeder Termin wird ausgegeben */));
    }
}
