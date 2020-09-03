package org.example.financialcontroller.hibernate.entity;

import org.example.financialcontroller.hibernate.entity.abstr.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "expense_operation")
public class ExpenseOperations extends AbstractEntity {

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id", nullable = false)
    Operation operationId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_id", nullable = false)
    Expense expenseId;

    public ExpenseOperations() {

    }

    public Operation getOperationId() {
        return operationId;
    }

    public void setOperationId(Operation operationId) {
        this.operationId = operationId;
    }

    public Expense getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Expense expenseId) {
        this.expenseId = expenseId;
    }
}
