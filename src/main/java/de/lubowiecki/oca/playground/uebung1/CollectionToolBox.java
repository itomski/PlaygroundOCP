package de.lubowiecki.oca.playground.uebung1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionToolBox<T extends Comparable> {

    // Mit natürlicher Reihenfolge: compareTo-Methode muss implementiert sein
    public List<T> toSortedList(Collection<T> collection) {
        List<T> list = new ArrayList<>(collection);
        Collections.sort(list);
        return list;
    }
}
