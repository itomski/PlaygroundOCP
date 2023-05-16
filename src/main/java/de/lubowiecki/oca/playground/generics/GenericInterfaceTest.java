package de.lubowiecki.oca.playground.generics;

public class GenericInterfaceTest {

    public static void main(String[] args) {

        Editor e = new Editor(); // Generische Typ ist Object
        // int i = e.aendern(1);
        // e.aendern("Hallo");

        Editor<String> e2 = new Editor<>();
        String s = (String) e2.aendern((String)"Hallo");
    }
}

interface Machbar<T> {

    T aendern(T t);

    T copieren(T t);
}

class Editor<T> implements Machbar<T> {

    @Override
    public T aendern(T t) {
        return null;
    }

    @Override
    public T copieren(T t) {
        return null;
    }
}

class StringEditor implements Machbar<String> {

    @Override
    public String aendern(String s) {
        return null;
    }

    @Override
    public String copieren(String s) {
        return null;
    }
}

class ZahlenEditor implements Machbar<Integer> {

    @Override
    public Integer aendern(Integer integer) {
        return null;
    }

    @Override
    public Integer copieren(Integer integer) {
        return null;
    }
}