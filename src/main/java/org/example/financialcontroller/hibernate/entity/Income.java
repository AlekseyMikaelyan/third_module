package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "income")
public class Income extends AbstractEntity {

    @Column(name = "amount", nullable = false)
    Integer amount;

    @Column(name = "from_where", nullable = false)
    String typeOfIncomes;

    public Income() {}

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTypeOfIncomes() {
        return typeOfIncomes;
    }

    public void setTypeOfIncomes(String typeOfIncomes) {
        this.typeOfIncomes = typeOfIncomes;
    }
}
