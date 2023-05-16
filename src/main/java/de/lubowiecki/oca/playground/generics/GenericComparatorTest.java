package de.lubowiecki.oca.playground.generics;

import java.util.*;

public class GenericComparatorTest {

    public static void main(String[] args) {

        //List<String> namen = new ArrayList<>(Arrays.asList("Peter", "Carol", "Natasha", "Bruce", "Steve"));
        List<String> namen = new ArrayList<>(List.of("Peter", "bruce", "Carol", "Natasha", "Bruce", "Steve", "carol")); // Ab Java 9

        Collections.sort(namen);
        System.out.println(namen);

        //namen.sort(new NachZeichenlaenge());
        namen.sort(new NachAlphabet());
        // Collections.sort(namen, comp);
        System.out.println(namen);

        Comparator<String> comp2 = (a, b) -> String.CASE_INSENSITIVE_ORDER.reversed().compare(a, b);
        namen.sort(comp2);
        System.out.println(namen);

        System.out.println();

        List<Integer> zahlen = List.of(1,3,22,15,7,9,8);
        List<Integer> sortiert = Sorter.sort(zahlen, (a, b) -> a - b);

        System.out.println();

        List<Benutzer> benutzerListe = new ArrayList<>();
        benutzerListe.add(new Benutzer(1, "Peter", "Parker"));
        benutzerListe.add(new Benutzer(5, "Bruce", "Banner"));
        benutzerListe.add(new Benutzer(2, "Carol", "Danvers"));

        List<Benutzer> sortierteBenutzer = Sorter.sort(benutzerListe, (b1, b2) -> b1.getId() - b2.getId());
        System.out.println(sortierteBenutzer);

        System.out.println();

        sortierteBenutzer = Sorter.sort(benutzerListe, (b1, b2) -> b1.getVorname().compareTo(b2.getVorname()));
        System.out.println(sortierteBenutzer);

        System.out.println();

        List<Integer> zahlen2 = new ArrayList<>();
        zahlen2.add(17);
        zahlen2.add(22);
        zahlen2.add(1);
        zahlen2.add(9);
        zahlen2.add(18);

        Object[] objArr = zahlen2.toArray();

        System.out.println();

        Integer[] intArr = zahlen2.toArray(new Integer[]{});
        System.out.println(Arrays.toString(intArr));

        System.out.println();

        intArr = zahlen2.toArray(new Integer[10]);
        System.out.println(Arrays.toString(intArr));

    }
}

class NachZeichenlaenge implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

class NachAlphabet implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
    }
}

class Sorter {

    // Generischer Typ auf Methoden Ebene
    public static <T> List<T> sort(Collection<T> list, Comparator<T> comp) {
        List<T> neueListe = new ArrayList<>(list);
        Collections.sort(neueListe, comp);
        return neueListe;
    }
}
