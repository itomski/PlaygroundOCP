package de.lubowiecki.oca.playground.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorTest {

    public static void main(String[] args) {

        Stream<Integer> ints = Stream.of(2,5,19,22,17,1,8,25);

        List<Integer> auswahl = ints.filter(i -> i > 10).collect(Collectors.toList());
        System.out.println(auswahl);

        ints = Stream.of(2,5,19,22,17,1,8,25);
        Set<Integer> auswahl2 = ints.filter(i -> i > 10).collect(() -> new HashSet<>(), (а, b) -> auswahl.add(b), (a, b) -> a.addAll(b));
        System.out.println(auswahl2);

        // addAll (letzte Parameter) wird nur im parallelen Umfeld verwendet
        // auswahl2 = ints.filter(i -> i > 10).collect(HashSet::new, Set::add, Set::addAll);

        System.out.println();

        Stream<String> strings = Stream.of("A", "B", "C", "D");
        // Collectors.joining fasst den Inhalt eines Stream als String zusammen
        //String str = strings.map(s -> s.toLowerCase()).collect(Collectors.joining());
        String str = strings.map(s -> s.toLowerCase()).collect(Collectors.joining("--", "{", "}"));
        System.out.println(str);

        System.out.println();

        strings = Stream.of("Peter", "Bruce", "Anna", "Carol", "Pat", "Bob", "Tony");
        // Die Werte werden nach einem vorgegebenen Wert gruppiert
        Map<Character, List<String>> sammlung = strings.collect(Collectors.groupingBy(n -> n.charAt(0)));
        System.out.println(sammlung);

        System.out.println();

        List<Student> studenten = new ArrayList<>();
        studenten.add(new Student("Anna", "Informatik", "Hamburg", 3));
        studenten.add(new Student("Peter", "Mathematik", "Berlin", 3));
        studenten.add(new Student("Bob", "Informatik", "Berlin", 4));
        studenten.add(new Student("Carol", "BWL", "München", 1));
        studenten.add(new Student("Hans", "Mathematik", "München", 2));
        studenten.add(new Student("Natasha", "BWL", "Münster", 1));

        Map<String, List<Student>> gruppiert = studenten.stream().collect(Collectors.groupingBy(s -> s.getFach()));

        // Als Methodenreferenz
        // Map<String, List<Student>> gruppiert = studenten.stream().collect(Collectors.groupingBy(Student::getFach));

        //System.out.println(gruppiert);
        //System.out.println(gruppiert.get("BWL"));
        System.out.println(gruppiert.get("Informatik"));

        System.out.println();

        gruppiert = studenten.stream().collect(Collectors.groupingBy(Student::getStadt));
        System.out.println(gruppiert.get("München"));

        System.out.println();

        Map<Integer, List<Student>> gruppiert2 = studenten.stream().collect(Collectors.groupingBy(Student::getSemester));
        System.out.println(gruppiert2.get(1));

        // Partitionieren
        System.out.println();

        // Unterteilt die Menge in Werte die einer Behauptung entsprechen oder nicht! Es gibt nur zwei Gruppen
        Map<Boolean, List<Student>> partition = studenten.stream().collect(Collectors.partitioningBy(s -> s.getSemester() > 3));
        // System.out.println(partition);
        System.out.println(partition.get(true));

    }
}

class Student {

    private String name;

    private String fach;

    private String stadt;

    private int semester;

    public Student(String name, String fach, String stadt, int semester) {
        this.name = name;
        this.fach = fach;
        this.stadt = stadt;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fach='" + fach + '\'' +
                ", stadt='" + stadt + '\'' +
                ", semester=" + semester +
                '}';
    }
}
