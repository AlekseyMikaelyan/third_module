package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.Operation;
import org.hibernate.Session;

import java.util.List;

public class OperationDaoImpl implements Dao<Operation> {

    private Session session;

    public OperationDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Operation operation) {
        session.save(operation);
    }

    @Override
    public Operation findById(Long id) {
        return session.get(Operation.class, id);
    }

    @Override
    public List<Operation> findAll() {
        return session.createQuery("from Operation").list();
    }
}
