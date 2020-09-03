package org.example.financialcontroller.hibernate.dao.impl;

import org.example.financialcontroller.hibernate.dao.interfaces.Dao;
import org.example.financialcontroller.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements Dao<User> {

    private Session session;

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(User user) {
        session.save(user);
    }

    @Override
    public User findById(Long id) {
        return session.get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    public int getUserId(String userName, String phoneNumber) throws Exception {

        Query query = session.createSQLQuery("select * from users where name_of_user = :userName and phone_number = :phoneNumber");
        query.setParameter("userName" , userName);
        query.setParameter("phoneNumber" , phoneNumber);
        List users = query.list();

        if(users.size() == 0){
            return 0;
        } else {

            Object[] curUsers = (Object[]) users.get(0);
            return (int)curUsers[0];
        }
    }

    public boolean isUserExists(String userName, String phoneNumber) throws Exception {

        int id = getUserId(userName , phoneNumber);
        if(id == 0) {
            return false;
        } else {
            return true;
        }
    }
}
