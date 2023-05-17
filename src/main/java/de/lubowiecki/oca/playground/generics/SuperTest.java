package de.lubowiecki.oca.playground.generics;

import java.util.ArrayList;
import java.util.List;

public class SuperTest {

    public static void main(String[] args) {

        String s1 = "Hallo Welt";
        // String hat verschiedene Eigenschaften und Methoden

        Object o = new Object();
        // Hat keine Eigenschaften

        //String s2 = (String) new Object(); // JVM kann keine String-Eigenschaften automatisch erfinden

        o = s1;
        String s2 = (String) o; // Geht!

        List<? super String> namen = new ArrayList<>();
        namen = new ArrayList<CharSequence>();
        namen = new ArrayList<Object>();

        List<CharSequence> seqList = new ArrayList<>();
        seqList.add("Hi");
        seqList.add(new StringBuilder("Hi").append("..."));
        seqList.add(new StringBuffer("Xyz").append("..."));
        namen = seqList;

        for(Object s : namen) { // Identität ist nicht sichergestellt
            System.out.println(s);
        }

        // seqList.forEach();

    }
}
