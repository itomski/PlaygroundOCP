package de.lubowiecki.oca.playground.generics.orm;

public class OrmTest {

    public static void main(String[] args) {

        Todo t1 = new Todo();
        t1.setId(1);

        TodoRepository repo = new TodoRepository();
        repo.delete(t1);

    }
}
