package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @NaturalId
    @Column(name = "name_of_user")
    private String userName;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
