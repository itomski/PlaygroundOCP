package de.lubowiecki.oca.playground.uebung.cal;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

// Repository
public class Kalender {

    // Collection für die Aufbewahrung der aktuellen Daten
    private Map<LocalDate, Set<Termin>> termine;

    private final String FILE_NAME = "cal.ser"; // TODO: Optimieren

    public Kalender() throws Exception {
        // Collection wird mit Altdaten aus der Datei belegt
        load();
    }

    public void add(Termin termin) throws IOException {
        // Liste für ein Datum erzeugen, wenn das Datum bis jetzt nicht vorhanden war
        termine.putIfAbsent(termin.getDatum(), new TreeSet<>()); // Leeres TreeSet für den Tag wird erzeugt

        // Termin wird in das TreeSet eingetragen
        termine.get(termin.getDatum()).add(termin);

        save(); // Speichert den aktuellen Stand in eine Datei
    }

    public Map<LocalDate, Set<Termin>> getAll() {
        return termine;
    }

    public Set<Termin> getByDate(LocalDate date) {
        // return termine.get(date);

        // Wenn für das Datum bis jetzt keine Termine vorliegen, wird eine leere Liste zurückgegeben
        return termine.getOrDefault(date, new TreeSet<>());
    }

    private void save() throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            // Serialisierungs-Datei wird beim Schreiben erzeugt, wenn sie nicht bereits existiert
            out.writeObject(termine); // Serialisiert Objekt-Strukturen d.h. Java-Objekte werden zu Text, so dass sie in eine Datei geschrieben werden können
        }
    }

    // Altdaten werden geladen
    private void load() throws IOException, ClassNotFoundException {
        // Verbindung zur Datei wird aufgebaut
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Daten werden als aus der Datei Objekt gelesen (inkl. Unterobjekte)
            termine = (Map<LocalDate, Set<Termin>>) in.readObject(); // Deserialisiert Objekt-Strukturen (Daten aus der Datei werden wieder zur Java Objekten)
        }
        catch(FileNotFoundException | EOFException e) { // Wenn die Serialisierungs-Datei nicht da oder leer ist
            termine = new TreeMap<>();
        }
    }
}
