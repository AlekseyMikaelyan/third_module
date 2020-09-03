package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.Income;
import org.hibernate.Session;

import java.util.List;

public class IncomeDaoImpl implements Dao<Income> {
    private Session session;

    public IncomeDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Income income) {
        session.save(income);
    }

    @Override
    public Income findById(Long id) {
        return session.get(Income.class, id);
    }

    @Override
    public List<Income> findAll() {
        return session.createQuery("from Income").list();
    }
}
