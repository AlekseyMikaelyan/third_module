package org.example.financialcontroller.jdbc.entity;

public class IncomeOperation {
    public int operationId;
    public int IncomeId;

    public IncomeOperation(int operationId, int incomeId) {
        this.operationId = operationId;
        IncomeId = incomeId;
    }
}
