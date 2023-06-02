package de.lubowiecki.oca.playground.jdbc;

import java.sql.*;

public class TransactionTest {

    public static void main(String[] args) {

        try(Connection connection = DbConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()) {


            Savepoint sp = null;

            try {
                connection.setAutoCommit(false); // Anweisungen werden nicht sofort, sondern erst beim comit übertragen
                stmt.execute("INSERT INTO users (id, firstname, lastname, birthdate) VALUE(null, 'Bruce', 'Banner', '1998-12-19')");
                sp = connection.setSavepoint();
                stmt.execute("INSERT INTO users (id, firstname, lastname, birthdate) VALUE(null, 'Natasha', 'Romanov', '1998-01-10')");
                stmt.execute("INSERT INTO users (id, firstname, lastname, birthdate) VALUE(null, 'Steve', 'Rogers', '1998-20-10')");
                connection.commit(); // Es wird nur dann etwas ausgeführt, wenn ALLE Anweisungen erfolgreich ausgeführt werden können
            }
            catch(Exception e) {
                // connection.rollback(); // Entfernt ALLE Anweisungen aus der Ausführung Queue

                connection.rollback(sp); // Entfernt die Anweisungen bis zu dem Savepoint
                connection.commit(); // Nach dem Zurückrollen muss das was noch drin ist an die DB übertragen werden
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }



}
