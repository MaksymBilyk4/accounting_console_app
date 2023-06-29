package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Service<T> {
    List<T> getAll();
    boolean create(T entity);
    boolean delete(T entity);
    Optional<T> getById(long entityId);
    Optional<T> getByDate(Date date);
    Optional<T> getByName(String name);
    List<T> generateEntities();
}
