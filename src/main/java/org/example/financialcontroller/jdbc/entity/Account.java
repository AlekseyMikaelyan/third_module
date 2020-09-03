package org.example.financialcontroller.jdbc.entity;

public class Account {

    public int id;
    public String name;
    public int userId;

    public Account(String name){
        this.name = name;
    }

    public Account(int id, String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
