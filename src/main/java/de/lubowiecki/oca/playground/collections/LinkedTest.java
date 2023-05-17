package de.lubowiecki.oca.playground.collections;

public class LinkedTest {

    public static void main(String[] args) {

        LinkedContainer<String> start = new LinkedContainer<>("Peter");
        start.setNext(new LinkedContainer<>("Steve"));
        start.getNext().setNext(new LinkedContainer<>("Natasha"));

        LinkedContainer<String> e = start;

        while(true) {
            if (e != null) {
                System.out.println(e.getValue());
                e = e.getNext();
            } else {
                break;
            }
        }
    }
}

class LinkedContainer<E> {

    private LinkedContainer<E> prev;
    private LinkedContainer<E> next;
    private E value;

    public LinkedContainer(E value) {
        this.value = value;
    }

    public LinkedContainer<E> getPrev() {
        return prev;
    }

    public void setPrev(LinkedContainer<E> prev) {
        this.prev = prev;
    }

    public LinkedContainer<E> getNext() {
        return next;
    }

    public void setNext(LinkedContainer<E> next) {
        this.next = next;
        next.setPrev(this);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
