package de.lubowiecki.oca.playground.lambdas;

public class LambdaTest1 {

    public static void main(String[] args) {

        //new LambdaTest1().machWas(new Pause());

        Machbar arbeit = new Machbar() {
            @Override
            public void machEs(int x) {
                System.out.println("Ich mache meine Arbeit! " + x);
            }
        };

        //new LambdaTest1().machWas(arbeit);

        // Ab Java 8
        //  void machEs(int i);
        new LambdaTest1().machWas(j -> {
            System.out.println("Ich mache irgendwas! " + j);
            // return j; // Falscher Rückgabetyp. Muss void sein!
        });


        Object o = new String();
        o = new Pause();

        // Object hat keine abstrakte Methode, die für Lambdas notwendig ist
        // o = (a) -> System.out.println("Output: " + a); // Error
        o = (Machbar)(a) -> System.out.println("Output: " + a); // Möglich

    }

    public void machWas(Machbar m) {
        m.machEs(10);
    }
}

@FunctionalInterface // Regeln für ein SAM werden überprüft
interface Machbar {
    void machEs(int i);
}

class Pause implements Machbar {

    @Override
    public void machEs(int i) {
        System.out.println("Macht Pause! " + i);
    }
}
