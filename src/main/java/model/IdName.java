package model;

import java.util.Objects;

public abstract class IdName<T extends IdName> {
    private final String id;
    private final String name;
    private final String stringRepresentation;

    public IdName(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.stringRepresentation = id + " : " + name;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        T t = (T)o;
        return this.id.equals(t.id());
    }

}
