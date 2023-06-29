package dao;

import java.util.List;

public interface Dao<T>{

    List<T> findAll();

    boolean save(T entity);


    boolean delete(T entity);
}
