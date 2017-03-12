package ua.litovka.service.api;

import java.util.List;

/**
 * Created by SergLion on 22.02.2017.
 */
public interface Service <K, T>{

    List<T> getAll();

    T getById(K id);

    void save(T entity);

    void delete(K key);

    void update(T entity);


}
