package de.lubowiecki.oca.playground.lambdas;

@FunctionalInterface
public interface CustomFuncInterface {

    int i = 10; // im Interface ist jede Eigenschaft public static final

    // abstrakte Methode
    int executeOp(int a, int b);

    static double getPi() {
        return 3.14;
    }

    default int add(int a, int b) {
        return a + b;
    }

    @Override
    String toString(); // Alle Methoden von Object werden nicht als abstrakte Mehtoden gezählt
}
