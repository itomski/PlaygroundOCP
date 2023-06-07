package de.lubowiecki.oca.playground.lambdas;

public class Fahrzeug {

    private String kennzeichen;

    private int baujahr;

    private int kmStand;

    public Fahrzeug() {
    }

    public Fahrzeug(String kennzeichen, int baujahr, int kmStand) {
        this.kennzeichen = kennzeichen;
        this.baujahr = baujahr;
        this.kmStand = kmStand;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public int getKmStand() {
        return kmStand;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }
}

