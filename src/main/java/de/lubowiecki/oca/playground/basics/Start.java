package de.lubowiecki.oca.playground.basics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Start {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        String s1 = "Text...";

        var s2 = "Hallo Welt"; // s2 ist ein String
        s2 = "123";

        int i = 10;
        i = 'c'; // automatisch möglich
        //i = 10.0; // automatisch NICHT möglich

        byte b1 = 10;
        byte b2 = 10;
        //b2 = b1 + b2; // Mathematische Operationen führen mind. zu einem int
        b1 += b2; // b1 = (byte)(b1 + b2);
        b1++; // b1 = (byte)(b1 + 1);

        final boolean bo1 = true; // Kompiletime-Konstante
        final boolean bo2;
        bo2 = false; // Runtime-Konstante

        while(bo2) {
        }
        System.out.println("Ende");

        System.out.println();

        int[] arr = {1,7,29,22,1,19,5};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));

        long l1 = 10; // int, primitive widening zu long
        // Long l2 = 10; // int, Autoboxing von int zu Integer, dann Komplex-Widening von Integer zu Long (nicht möglich)
        Number l3 = 10; // int, Autoboxing von int zu Integer, dann Komplex-Widening zu Number, IS-A Beziehung muss existieren
        Long l2 = 10l; // long, Autoboxing zu Long

        int i2;
        //System.out.println(i2); // i2 ist nicht initialisiert!!! darf nicht benutzt werden

        l2 = 10_000_000_000l; // damit die zahl ein echter long ist muss ein L ran

        i2 = 011; // 1x8 + 1 = 8
        i2 = 0b11; // 1x2 + 1 = 3
        i2 = 0x11; // 1x16 + 1 = 17
        i2 = 11; // 1x10 + 1 = 11

        try {
            //System.out.println(10/0);
            Double d = 10.0/0.0;
            if(d.isInfinite()) {
                System.out.println("Teilung duch 0.0");
            }
        }
        catch (ArithmeticException e) {
            System.out.println("Exxception: " + e.getMessage());
        }

        System.out.println();

        Integer i4 = 128;
        Integer i5 = 128; // Byte Literal Pool (-128 bis 127) (Ganzzahlen)
        System.out.println(i4 == i5);
        System.out.println(i4.equals(i5));


        Long l4 = 10l;
        //System.out.println(i4 == l4); // Nicht vergleichbar, weil komplexe Datentyp unterschiedlich

        long l6 = 10l;
        int i6 = 10;
        System.out.println(i6 == l6); // i6 promoviert primitiv zu long und dann wertevergleich

        String s5 = "Hallo"; // landet im Pool
        s5 = new String("Hallo"); // landet NICHT im Pool


        List<String> namen = new ArrayList<>();
        namen.add("Peter");
        namen.add("Bruce");
        namen.add("Steve");
        namen.add("Carol");
        //namen.add(10); // Kann nur String aufnehmen

        // CharSequence ist Parent von String und StringBuilder (und StringBuffer)
        List<CharSequence> namen2 = new ArrayList<>();
        namen2.add("Peter");
        namen2.add(new StringBuilder("Bruce"));

        System.out.println();

        // Vergleichen von Objekten
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1 == o2); // Referenzvergleich
        System.out.println(o1.equals(o2)); // Inhaltsvergleich. Bei Object auch nur Referenzvergleich, da kein Inhalt verfügbar

        System.out.println();

        String s6 = "Moin"; // Im Pool
        String s7 = new String("Moin"); // Nicht im Pool
        System.out.println(s6 == s7);
        System.out.println(s6.equals(s7));

        System.out.println();

        LocalDate d6 = LocalDate.now();
        LocalDate d7 = LocalDate.now();
        System.out.println(d6 == d7);
        System.out.println(d6.equals(d7));

        System.out.println();

        SuperHero hulk1 = new SuperHero("Hulk");
        SuperHero hulk2 = new SuperHero("Hulk");
        System.out.println(hulk1 == hulk2);
        System.out.println(hulk1.equals(hulk2));

        System.out.println(hulk1.hashCode());
        System.out.println(hulk2.hashCode());

        System.out.println();

        //List<Integer> zahlen = List.of(5,7,99,13,1,18); // Ab Java 9 verfügbar
        List<Integer> zahlen = Arrays.asList(5,7,99,13,1,18);
        zahlen.forEach(z -> System.out.println(z)); // Mit Lambda
    }

    private static void machWas() {
        // Kein return nötig (void)
    }

    private static int machWasAnderes() {
        throw new RuntimeException("Bla bla bla"); // Kein return nötig (Exception wird geworfen)
    }

    private static int machWasGanzAnderes() {
        return 1; // return nötig
    }
}

class SuperHero {

    private String name;

    public SuperHero(String name) {
        this.name = name;
    }

    /*
    @Override
    public boolean equals(Object obj) {

        // Ist es das gleiche Objekt auf dem Heap
        if(this == obj)
            return true;

        // Ist es vom gleichen Typ?
        if(!(obj instanceof SuperHero))
            return false;

        // Inhaltsvergleich
        SuperHero other = (SuperHero)obj;
        return name.equals(other.name);
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return Objects.equals(name, superHero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
