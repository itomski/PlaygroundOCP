package de.lubowiecki.oca.playground.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

// Sollen Objekte einer Klasse serialisiert werden können, muss die Klasse das Serializable-Interface implementieren
public class Person implements Serializable {

    private static final long serialVersionUID = 2L;

    private String firstname;

    private String lastname;

    // transient: Feld wird bei der Serialisierung ausgelassen
    private transient LocalDate birthdate = null;

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

    /*
    // Steuerung der Serialisierung und Deserialisierung
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("CUSTOM READ");
        firstname = in.readUTF();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("CUSTOM WRITE");
        out.writeUTF(firstname);
    }
    */

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
