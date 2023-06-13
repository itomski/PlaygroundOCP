package de.lubowiecki.oca.playground.uebung.cal;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

// Repository
public class Kalender {

    private Map<LocalDate, Set<Termin>> termine;

    private final String FILE_NAME = "cal.ser"; // TODO: Optimieren

    public Kalender() throws Exception {
        load(); // belegt Termine mit Altdaten oder einer leeren Map
    }

    public void add(Termin termin) throws IOException {
        // Liste für ein Datum erzeugen, wenn das Datum bis jetzt nicht vorhanden war
        termine.putIfAbsent(termin.getDatum(), new TreeSet<>());

        // Termin der Liste für ein Datum hinzufügen
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
            out.writeObject(termine); // Serialisiert Objekt-Strukturen
        }
    }

    // Altdaten werden geladen
    private void load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            termine = (Map<LocalDate, Set<Termin>>) in.readObject(); // Deserialisiert Objekt-Strukturen
        }
        catch(FileNotFoundException | EOFException e) { // Wenn die Serialisierungs-Datei nicht da oder leer ist
            termine = new TreeMap<>();
        }
    }
}
