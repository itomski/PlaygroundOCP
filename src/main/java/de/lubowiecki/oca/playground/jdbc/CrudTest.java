package de.lubowiecki.oca.playground.jdbc;

import java.sql.SQLException;

public class CrudTest {

    public static void main(String[] args) {

        try {
            UserCrud crud = new UserCrud();
            crud.findAll().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
