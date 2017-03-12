package ua.litovka.model;

/**
 * Created by SergLion on 21.02.2017.
 */
public class Entity<T> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity<?> entity = (Entity<?>) o;

        return getId().equals(entity.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
