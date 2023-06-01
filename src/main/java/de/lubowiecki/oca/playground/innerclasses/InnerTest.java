package de.lubowiecki.oca.playground.innerclasses;

import java.util.Arrays;
import java.util.Comparator;

// TopLevel
public class InnerTest {

    public static void main(String[] args) {

        // Object von StaticInner kann ohne ein Objekt von InnerTest existieren
        //InnerTest.StaticInner staticInner = new InnerTest.StaticInner();
        InnerTest.StaticInner staticInner = new StaticInner();

        // Object von Inner kann nur über eine Instanz von InnerTest erzeugt werden
        InnerTest.Inner inner = new InnerTest().new Inner();

        InnerTest test = new InnerTest();
        inner = test.new Inner();

        // Klasse wird in einer Methode deklariert
        // Kann nur dort instanziert werden, wo sie deklariert wurde

        int i = 10;
        final int j = 20;

        class LocalClass {

            void machWas() {
                System.out.println(i + j); // i ist nicht mehr effektiv final
            }
        }

        //i = 20;
        //j = 40; // Problem, finale Variablen dürfen ihren Wert nicht ändern

        LocalClass lc = new LocalClass();
        lc.machWas();

        // Es wird einen anonyme Klasse deklariert, die Comparator implemeniert und die sofort instanziert wird
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        // Deklaration hat keinen Namen, kann daher nicht noch mal instanziert werden
    }

    public static void machWas() {
        // Hier ist die Klasse nicht bekannt
        // LocalClass lc = new LocalClass();
    }


    // NICHT TopLevel (public, protected, package-private, private) (können static sein)
    class Inner { // Mitgliedsklasse (Instanz)

        static String text = "....";

    }

    static class StaticInner { // statische innere Klasse

    }
}
