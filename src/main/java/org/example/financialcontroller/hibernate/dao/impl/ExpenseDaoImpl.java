package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.Expense;
import org.hibernate.Session;

import java.util.List;

public class ExpenseDaoImpl implements Dao<Expense> {

    private Session session;

    public ExpenseDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Expense expense) {
        session.save(expense);
    }

    @Override
    public Expense findById(Long id) {
        return session.get(Expense.class, id);
    }

    @Override
    public List<Expense> findAll() {
        return session.createQuery("from Expense").list();
    }
}
