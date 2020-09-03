package org.example.financialcontroller.jdbc.entity;

public class ExpenseOperation {
    public int OperationId;
    public int ExpenseId;

    public ExpenseOperation(int operationId, int expenseId) {
        OperationId = operationId;
        ExpenseId = expenseId;
    }
}
