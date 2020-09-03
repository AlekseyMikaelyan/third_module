package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.Account;
import org.example.financialcontroller.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements Dao<Account> {

    private Session session;

    public AccountDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Account account) {
        session.save(account);
    }

    @Override
    public Account findById(Long id) {
        return session.get(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = session.createQuery("from Account").list();
        return accountList;
    }

    public List<Account> getAccountsByUserId(Long userId) {

        Query query = session.createSQLQuery("select * from account where user_id = :id ");
        query.setParameter("id", userId);

        List users = query.list();

        if (users.size() == 0) {

            return new ArrayList<>();

        } else {

            List<Account> accounts = new ArrayList<>();

            UserDaoImpl userDao = new UserDaoImpl(session);

            for (Object item : users) {
                Object[] curItem = (Object[]) item;

                Account newAccount = new Account();
                newAccount.setId((Long) curItem[0]);
                newAccount.setName((String) curItem[1]);
                newAccount.setUser(userDao.findById((Long) curItem[2]));

                accounts.add(newAccount);
            }
            return accounts;
        }
    }
}
