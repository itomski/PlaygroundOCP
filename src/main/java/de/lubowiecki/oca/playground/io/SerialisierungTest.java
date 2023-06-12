package de.lubowiecki.oca.playground.io;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerialisierungTest {

    private List<Person> list;
    private final Scanner scanner = new Scanner(System.in);

    private final String file = "data.ser";

    public static void main(String[] args) {
        new SerialisierungTest().start();
    }

    private void start() {

        try {
            load();

            System.out.println(list);

            System.out.println("----------------------\n");

            Person person = new Person();
            System.out.print("Vorname: ");
            person.setFirstname(scanner.nextLine());
            System.out.print("Nachname: ");
            person.setLastname(scanner.nextLine());
            System.out.print("Geburtsdatum (YYYY-MM-DD): ");
            person.setBirthdate(LocalDate.parse(scanner.nextLine()));
            list.add(person);

            save();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void save() throws IOException {

        // ObjectOutputStream: Serialisierung von Objekten
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(list); // Es wird das Objekt inkl. aller Unterobjekte gespeichert
        }
    }

    private void load() {

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            list = (List<Person>) in.readObject();
        }
        catch (Exception e) {
            list = new ArrayList<>();
        }
    }
}
