package de.lubowiecki.oca.playground.collections;

import java.lang.management.GarbageCollectorMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    public static void main(String[] args) {

        Map<String, Integer> einwohner = new HashMap<>();
        einwohner.put("Hamburg", 1_900_000);
        einwohner.put("München", 1_600_000);
        einwohner.put("Kiel", 400_000);
        einwohner.put("Münster", 1_000_000);
        System.out.println(einwohner);

        System.out.println(einwohner.get("Hamburg"));
        System.out.println(einwohner.get("Kiel"));
        System.out.println(einwohner.getOrDefault("Kiel", 0));

        System.out.println();

        for(int e : einwohner.values()) { // Abfragen von Werten ohne Schlüsseln
            System.out.println(e);
        }

        System.out.println();

        for(String k : einwohner.keySet()) { // Abfragen von Schlüsseln
            System.out.println(k);
        }

        System.out.println();

        for(String k : einwohner.keySet()) {
            System.out.println(einwohner.get(k));
        }

        System.out.println();

        // Besser
        for(Map.Entry<String, Integer> e : einwohner.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        einwohner.put("Hamburg", 2_000_000); // Update auf dem Wert für Hamburg
        System.out.println(einwohner);

        //Map<String, Integer> einwohnerSortiert = new TreeMap<>(); // Sortiert nach Key
        Map<String, Integer> einwohnerSortiert = new TreeMap<>(String.CASE_INSENSITIVE_ORDER.reversed()); // Sortiert nach Key / umgekehrt
        einwohnerSortiert.putAll(einwohner);
        System.out.println(einwohnerSortiert);

        einwohner.putIfAbsent("Hamburg", 2_200_000); // Key bereits vorhanden - Hinzufügen erfolgt nicht
        System.out.println(einwohner);

    }
}
