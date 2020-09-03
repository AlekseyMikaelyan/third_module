package org.example.financialcontroller.jdbc.dao;

import org.example.financialcontroller.jdbc.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface JdbcDao {
    List<Account> getAccounts() throws SQLException;

    List<Expense> getExpenses() throws SQLException;

    List<Income> getIncomes() throws SQLException;

    List<Operation> getOperation() throws SQLException;

    List<IncomeOperation> getIncomeOperation() throws SQLException;

    List<ExpenseOperation> getExpenseOperation() throws SQLException;

    List<User> getUsers() throws SQLException;
}
