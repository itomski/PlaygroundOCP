package de.lubowiecki.oca.playground.patterns;

import java.time.Year;

public class BuilderTest {

    public static void main(String[] args) {

        Fahrzeug f1 = new Fahrzeug("", "Ford", "Ka", 2010);
        // f1.setKennzeichen("HH-AB 123"); // Ist immutable
        System.out.println(f1);

        // Es müssen alle Werte an den Konstruktor übergeben werden...
        Fahrzeug f2 = new Fahrzeug("HH:AB123", "Ford", "Ka", 2010);
        Fahrzeug f3 = new Fahrzeug("HH:BZ335", "Ford", "Ka", 2010);

        System.out.println();

        Fahrzeug.Builder fahrzeugBuilder = new Fahrzeug.Builder();
        System.out.println(fahrzeugBuilder.build());

        fahrzeugBuilder.setMarke("Ford").setTyp("Mustang");
        System.out.println(fahrzeugBuilder.setKennzeichen("HH:AB123").build());
        System.out.println(fahrzeugBuilder.setKennzeichen("HH:BZ335").build());
        System.out.println(fahrzeugBuilder.setKennzeichen("HH:BZ340").build());
    }
}


class Fahrzeug {

    private final String kennzeichen;

    private final String marke;

    private final String typ;

    private final int baujahr;

    public Fahrzeug(String kennzeichen, String marke, String typ, int baujahr) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.typ = typ;
        this.baujahr = baujahr;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getMarke() {
        return marke;
    }

    public String getTyp() {
        return typ;
    }

    public int getBaujahr() {
        return baujahr;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "kennzeichen='" + kennzeichen + '\'' +
                ", marke='" + marke + '\'' +
                ", typ='" + typ + '\'' +
                ", baujahr=" + baujahr +
                '}';
    }

    public static class Builder {

        private String kennzeichen = "Unbekannt";

        private String marke = "Unbekannt";

        private String typ = "Unbekannt";

        private int baujahr = Year.now().getValue();

        public Builder setKennzeichen(String kennzeichen) {
            this.kennzeichen = kennzeichen;
            return this;
        }

        public Builder setMarke(String marke) {
            this.marke = marke;
            return this;
        }

        public Builder setTyp(String typ) {
            this.typ = typ;
            return this;
        }

        public Builder setBaujahr(int baujahr) {
            this.baujahr = baujahr;
            return this;
        }

        public Fahrzeug build() {
            return new Fahrzeug(kennzeichen, marke, typ, baujahr);
        }
    }
}