package de.lubowiecki.oca.playground.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionFactory {

    private static String url;
    private static String user;
    private static String password;

    static {
        init();
    }

    private DbConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        // Class.forName("com.mysql.jdbc.Driver"); // Für JDBC3
        return DriverManager.getConnection(url, user, password);
    }

    public static void init() {
        try {
            Properties prop = getProp();
            // getProperty = Fragt einen Wert über den Schlüssel ab. Ist ein Wert nicht verfügbar, wird ein Default-Wert benutzt
            user = prop.getProperty("db.user", "root");
            password = prop.getProperty("db.password", "");
            String host = prop.getProperty("db.host", "localhost");
            String port = prop.getProperty("db.port", "3306");
            String dbname = prop.getProperty("db.name", "standard");
            url = String.format("jdbc:mysql://%s:%s/%s", host, port, dbname);
        }
        catch(IOException e) {
            System.out.println("Konfiguration konnte nicht geladen werden.");
            System.exit(0);
        }
    }

    public static Properties getProp() throws IOException {

        // getClassLoader().getResourceAsStream(...) lädt eine Datei aus dem Class-Path (bei Maven Projekten java oder resources Ordner)
        try(InputStream in = DbConnectionFactory.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(in); // Befüllt das Properties-Objekt mit Daten aus der Datei
            return prop;
        }
    }
}
