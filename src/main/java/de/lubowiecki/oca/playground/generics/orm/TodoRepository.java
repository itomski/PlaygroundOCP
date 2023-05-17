package de.lubowiecki.oca.playground.generics.orm;

public class TodoRepository extends AbstractRepository<Todo> {

    public TodoRepository() {
        super("todos");
    }
}
