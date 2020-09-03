package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.IncomeOperations;
import org.hibernate.Session;

import java.util.List;

public class IncomeOperationsDaoImpl implements Dao<IncomeOperations> {

    private Session session;

    public IncomeOperationsDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(IncomeOperations incomeOperations) {
        session.save(incomeOperations);
    }

    @Override
    public IncomeOperations findById(Long id) {
        return session.get(IncomeOperations.class, id);
    }

    @Override
    public List<IncomeOperations> findAll() {
        return session.createQuery("from IncomeOperations").list();
    }
}
