package de.lubowiecki.oca.playground.generics;

public class Benutzer {

    private int id;

    private String vorname;

    private String nachname;

    public Benutzer() {
    }

    public Benutzer(int id, String vorname, String nachname) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Benutzer{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }
}
