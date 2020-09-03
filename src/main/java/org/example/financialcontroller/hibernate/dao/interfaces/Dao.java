package org.example.financialcontroller.hibernate.dao.interfaces;

import java.util.List;

public interface Dao <T> {
    void create(T t);
    T findById(Long id);
    List<T> findAll();
}
