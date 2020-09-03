package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.ExpenseOperations;
import org.hibernate.Session;

import java.util.List;

public class ExpenseOperationsDaoImpl implements Dao<ExpenseOperations> {

    private Session session;

    public ExpenseOperationsDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(ExpenseOperations expenseOperations) {
        session.save(expenseOperations);
    }

    @Override
    public ExpenseOperations findById(Long id) {
        return session.get(ExpenseOperations.class, id);
    }

    @Override
    public List<ExpenseOperations> findAll() {
        return session.createQuery("from ExpenseOperations").list();
    }
}
