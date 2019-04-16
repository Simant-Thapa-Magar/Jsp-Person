package dao;

import java.util.List;

public interface Dao<T> {
    List findAll();
    boolean add(T t);
    T findById(int id);
    boolean delete(int id);
    boolean update(T t);
}
