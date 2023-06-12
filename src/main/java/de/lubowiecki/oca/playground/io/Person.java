package de.lubowiecki.oca.playground.io;

import java.io.Serializable;
import java.time.LocalDate;

// Sollen Objekte einer Klasse serialisiert werden können, muss die Klasse das Serializable-Interface implementieren
public class Person implements Serializable {

    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    public Person() {
    }

    public Person(String firstname, String lastname, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
