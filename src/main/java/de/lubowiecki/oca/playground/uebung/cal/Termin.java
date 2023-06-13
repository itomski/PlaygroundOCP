package de.lubowiecki.oca.playground.uebung.cal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Termin implements Serializable, Comparable<Termin> {

    private LocalDate datum;

    private LocalTime zeit;

    private String titel;

    private String bemerkung;

    public Termin() {
    }

    public Termin(LocalDate datum, LocalTime zeit, String titel, String bemerkung) {
        this.datum = datum;
        this.zeit = zeit;
        this.titel = titel;
        this.bemerkung = bemerkung;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getZeit() {
        return zeit;
    }

    public void setZeit(LocalTime zeit) {
        this.zeit = zeit;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "datum: " + datum +
                ", zeit: " + zeit +
                ", titel: '" + titel + '\'' +
                ", bemerkung: '" + bemerkung + '\'';
    }

    @Override
    public int compareTo(Termin other) {
        return zeit.compareTo(other.getZeit());
    }
}
