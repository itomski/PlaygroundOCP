package de.lubowiecki.oca.playground.lambdas;

public class TestFuncInterface1 {

    public static void main(String[] args) {

        // int executeOp(int a, int b);
        CustomFuncInterface cfi = (x, y) -> x * y;
        cfi = (x, y) -> { return x * y; };

        System.out.println(cfi.executeOp(10, 15));
        System.out.println(cfi.add(10, 15)); // default Methode
        System.out.println(CustomFuncInterface.getPi()); // statische Methode
        System.out.println(cfi.i); // statisches Feld/Eigenschaft
        System.out.println(cfi.toString()); // methode des Objekts

    }
}
