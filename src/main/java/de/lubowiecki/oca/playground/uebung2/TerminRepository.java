package de.lubowiecki.oca.playground.uebung2;

import java.time.LocalDate;
import java.util.*;

public class TerminRepository implements Repository<Termin> {

    private Map<LocalDate,Termin> termine = new TreeMap<>();

    public List<Termin> fildAll() {
        return new ArrayList<>(termine.values());
    }

    public Termin find(LocalDate date) {
        return termine.get(date);
    }

    public void add(Termin t) {
        // TODO: Fix Problem falls ein Datum bereits belegt ist
        termine.put(t.getDatum(), t);
    }
}
