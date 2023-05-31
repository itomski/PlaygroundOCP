package de.lubowiecki.oca.playground.uebung2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CalApp {

    private final Scanner scanner = new Scanner(System.in);
    private final TerminRepository repository = new TerminRepository();

    private static final String TBL_ROW = "| %-10s | %-5s | %-20s | %-50s | \n";

    private static final String DIVIDER = "--------------------------------------------------------------------------------------------------\n";

    public static void main(String[] args) {
        new CalApp().start();
    }

    private void start() {

        app: while(true) {

            System.out.print("\nEingabe: ");
            String eingabe = scanner.nextLine().trim().toLowerCase();

            switch(eingabe) {

                case "n":
                    System.out.println("\nNeuer Termin");
                    repository.add(createTermin());
                    System.out.println("\nTermin wurde gespeichert.");
                    break;

                case "f": {
                        System.out.println("\nTerminsuche");
                        System.out.print("Datum [JJJJ-MM-TT]: ");
                        Termin t = repository.find(LocalDate.parse(scanner.nextLine()));
                        System.out.println(t);
                    }
                    break;

                case "l":
                    System.out.println("\nMeine Termine");

                    System.out.printf(TBL_ROW, "Datum", "Zeit", "Titel", "Beschreibung");
                    System.out.print(DIVIDER);
                    for(Termin t : repository.fildAll()) {
                        System.out.printf(TBL_ROW, t.getDatum(), t.getZeit(), t.getTitel(), t.getBeschreibung());
                    }
                    break;

                case "q":
                    break app;

                default:
                    System.out.println("\nFalsche Eingabe");
            }
        }

        System.out.println("\nProgrammende");
    }

    private Termin createTermin() {
        Termin t = new Termin();

        // TODO: Validierung

        System.out.print("Datum [JJJJ-MM-TT]: ");
        t.setDatum(LocalDate.parse(scanner.nextLine()));

        System.out.print("Zeit [HH:mm:ss]: ");
        t.setZeit(LocalTime.parse(scanner.nextLine()));

        System.out.print("Titel: ");
        t.setTitel(scanner.nextLine());

        System.out.print("Beschreibung: ");
        t.setBeschreibung(scanner.nextLine());

        return t;
    }
}
