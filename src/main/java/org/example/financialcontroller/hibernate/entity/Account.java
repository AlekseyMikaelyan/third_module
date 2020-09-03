package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

    @Column(name = "name_of_account")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account() {

    }

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
