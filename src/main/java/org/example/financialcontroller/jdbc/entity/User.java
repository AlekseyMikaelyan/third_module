package org.example.financialcontroller.jdbc.entity;

public class User {

    public int id;
    public String userName;
    public String phoneNumber;

    public User(int id, String userName, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
}
