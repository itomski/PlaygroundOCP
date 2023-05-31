package de.lubowiecki.oca.playground.uebung2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Termin {

    private LocalDate datum;

    private LocalTime zeit;

    private String titel;

    private String beschreibung;

    public Termin() {
    }

    public Termin(LocalDate datum, LocalTime zeit, String titel, String beschreibung) {
        this.datum = datum;
        this.zeit = zeit;
        this.titel = titel;
        this.beschreibung = beschreibung;
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

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "datum=" + datum +
                ", zeit=" + zeit +
                ", titel='" + titel + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }
}
