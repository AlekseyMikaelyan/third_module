package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "income_operation")
public class IncomeOperations extends AbstractEntity {

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id", nullable = false)
    Operation operationId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "income_id", nullable = false)
    Income incomeId;

    public IncomeOperations() {

    }

    public Operation getOperationId() {
        return operationId;
    }

    public void setOperationId(Operation operationId) {
        this.operationId = operationId;
    }

    public Income getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Income incomeId) {
        this.incomeId = incomeId;
    }
}
