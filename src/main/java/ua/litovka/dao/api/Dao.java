package ua.litovka.dao.api;



import ua.litovka.model.Entity;

import java.util.List;

/**
 * Created by SergLion on 21.02.2017.
 */
public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();

    T getById(K key);

    T getBy(String fieldName, String value);

    void save(T entity);

    void delete(K key);

    void update(T entity);
}
