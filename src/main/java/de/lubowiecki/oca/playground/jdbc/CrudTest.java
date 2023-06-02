package de.lubowiecki.oca.playground.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class CrudTest {

    public static void main(String[] args) {

        try {
            UserCrud crud = new UserCrud();

            // INSERT
            // User user = new User("Steve", "Rogers", LocalDate.of(1925, 1, 15));
            // crud.insert(user);
            // System.out.println(user.getId());

            Optional<User> opt = crud.findById(2);
            if(opt.isPresent()) {
                User user = opt.get();
                user.setFirstname("Max");
                crud.update(user);
            }

            // READ ALL
            crud.findAll().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            // READ ONE BY ID
            //crud.findById(100).ifPresent(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            // READ ALL BY BIRTHDATE
            //crud.findByBirthdate(LocalDate.of(2000, 12, 13))
            //      .forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));

            // DELETE BY ID
            // crud.deleteById(1);
            // crud.findAll().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
