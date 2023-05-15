package de.lubowiecki.oca.playground.basics;

public class Vererbung {

    public static void main(String[] args) {

        Parent p = new Child(); // Komplex Widening

        p.machWas();
        // p.machWasAnderes(); // Über p ist diese Methode nicht sichtbar
        ((Child)p).machWasAnderes(); // p wird zu Child gecastet

        System.out.println(p.zahl); // 10

        System.out.println();

        iterate(new String[]{"A", "B", "C"});

        System.out.println();

        iterate(null);

    }

    public static void iterate(String[] arr) {

        try {
            for(int i = 0; i <= arr.length; i++) {
                System.out.println(arr[i]);
                if(i == 2) {
                    return; // Verlässt die Methode
                }
            }
        }
        catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Fehler bei Verarbeitung");
        }
        finally {
            System.out.println("Ende");
        }
    }
}

class Parent {

    int zahl = 10;
    public void machWas() {
        System.out.println("Parent: machWas()");
    }
}

class Child extends Parent {

    int zahl = 20;

    public void machWas() {
        System.out.println("Child: machWas()");
    }

    public void machWasAnderes() {
        System.out.println("Child: machWasAnderes()");
    }
}