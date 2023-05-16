package de.lubowiecki.oca.playground.generics;

import java.util.Objects;

public class GenericBox<T> {

    private T content;

    public GenericBox() {
    }

    public GenericBox(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "GenericBox{" +
                "content=" + content +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericBox<?> that = (GenericBox<?>) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
