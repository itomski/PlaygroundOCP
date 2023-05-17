package de.lubowiecki.oca.playground.generics.orm;

public class UserRepository extends AbstractRepository<User>  {

    public UserRepository() {
        super("users");
    }
}
