package de.lubowiecki.oca.playground.generics;

public class GenericCalculator<T extends Number> {

    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double multi(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double sub(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double div(T a, T b) {
        return a.doubleValue() / b.doubleValue();
    }
}
