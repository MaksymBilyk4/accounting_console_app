package dao;

import java.util.ArrayList;
import java.util.List;

public class AbstractDao<T> implements Dao<T> {
    List<T> enititiesList = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return enititiesList;
    }

    @Override
    public boolean save(T entity) {
        return enititiesList.add(entity);
    }


    @Override
    public boolean delete(T entity) {
        return enititiesList.remove(entity);
    }
}
