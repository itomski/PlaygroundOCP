package de.lubowiecki.oca.playground.jdbc;

import java.time.LocalDate;

public class User extends AbstractEntity {

    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    public User() {
    }

    public User(String firstname, String lastname, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public User(int id, String firstname, String lastname, LocalDate birthdate) {
        this(firstname, lastname, birthdate);
        this.setId(id);
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
}
