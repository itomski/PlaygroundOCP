package de.lubowiecki.oca.playground.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;

public class CrudTest {

    public static void main(String[] args) {

        try {
            UserCrud crud = new UserCrud();

            // READ ALL
            //crud.findAll().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            // READ ONE BY ID
            //crud.findById(100).ifPresent(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            // READ ALL BY BIRTHDATE
            //crud.findByBirthdate(LocalDate.of(2000, 12, 13))
            //      .forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            // DELETE BY ID
            crud.deleteById(1);
            crud.findAll().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
