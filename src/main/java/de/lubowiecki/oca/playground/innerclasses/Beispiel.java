package de.lubowiecki.oca.playground.innerclasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Beispiel {

    private List<Person> personen = new ArrayList<>();

    public static void main(String[] args) {
        new Beispiel().start();
    }

    private void start() {

        personen.add(new Person(LocalDate.of(2000, 10, 15), "Peter", "Parker"));
        personen.add(new Person(LocalDate.of(2001, 8, 1), "Carol", "Danvers"));
        personen.add(new Person(LocalDate.of(2005, 2, 18), "Bruce", "Banner"));
        personen.add(new Person(LocalDate.of(1925, 5, 1), "Steve", "Rogers"));
        personen.add(new Person(LocalDate.of(1999, 1, 10), "Natasha", "Romanov"));

        Comparator<Person> comp1 = new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthDate().compareTo(b.getBirthDate());
            }
        };

        Comparator<Person> comp2 = new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getLastName().compareTo(b.getLastName());
            }
        };

        Collections.sort(personen, comp2);
        //personen.sort();

        Consumer<Person> cons1 = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getBirthDate() + ", " + person.getFirstName() + " " + person.getLastName());
            }
        };

        Consumer<Person> cons2 = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("{ birthdate='" + person.getBirthDate() + "', firstname='" + person.getFirstName() + "', lastname='" + person.getLastName() + "'}");
            }
        };

        personen.forEach(cons2);

    }
}
