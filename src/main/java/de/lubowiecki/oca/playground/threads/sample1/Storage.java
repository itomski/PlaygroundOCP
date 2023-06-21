package de.lubowiecki.oca.playground.threads.sample1;

import java.util.LinkedList;
import java.util.List;

public class Storage {

    private final List<Timber> timberStore = new LinkedList<>();

    private final int MAX_CAPACITY;

    public Storage(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    public void store(Timber timber) {

        if(timberStore.size() == MAX_CAPACITY)
            throw new RuntimeException("Lager voll");

        timberStore.add(timber);
    }

    public Timber get() {

        if(timberStore.size() > 0)
            return timberStore.remove(0);

        throw new RuntimeException("Lager leer");
    }

    public int getFillLevel() {
        return timberStore.size();
    }
}
