package de.lubowiecki.oca.playground.io;

public class TryWithResourcesTest {

    public static void main(String[] args) {

        try(CustomConnection con = CustomConnection.open()) {

        }
        catch(Exception e) {
        }
    }
}

class CustomConnection implements AutoCloseable {

    private CustomConnection() {
        System.out.println("OPEN");
    }

    public static CustomConnection open() {
        return new CustomConnection(); // Objekt richtig initialisieren
    }

    @Override
    public void close() throws Exception {
        System.out.println("CLOSE");
    }
}
