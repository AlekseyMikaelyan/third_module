package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense extends AbstractEntity {

    @Column(name = "amount", nullable = false)
    Integer amount;

    @Column(name = "for_what", nullable = false)
    String typeOfExpenses;

    public Expense() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTypeOfExpenses() {
        return typeOfExpenses;
    }

    public void setTypeOfExpenses(String typeOfExpenses) {
        this.typeOfExpenses = typeOfExpenses;
    }
}
