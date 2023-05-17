package de.lubowiecki.oca.playground.uebung1;

public class Fahrzeug implements Comparable<Fahrzeug> {

    private final String kennzeichen;

    private final int baujahr;

    private final int leistungInPs;

    public Fahrzeug(String kennzeichen, int baujahr, int leistungInPs) {
        this.kennzeichen = kennzeichen;
        this.baujahr = baujahr;
        this.leistungInPs = leistungInPs;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public int getLeistungInPs() {
        return leistungInPs;
    }

    @Override
    public int compareTo(Fahrzeug other) {
        //return this.leistungInPs - other.leistungInPs; // Nach Leistung
        //return this.baujahr - other.baujahr; // Nach Baujahr
        return this.kennzeichen.compareToIgnoreCase(other.kennzeichen); // Nach Kennzeichen
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "kennzeichen='" + kennzeichen + '\'' +
                ", baujahr=" + baujahr +
                ", leistungInPs=" + leistungInPs +
                '}';
    }
}
