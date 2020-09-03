package org.example.financialcontroller.jdbc.dao;

import org.apache.log4j.Logger;
import org.example.financialcontroller.jdbc.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoImpl implements JdbcDao {

    private static final Logger log = Logger.getLogger(JdbcDaoImpl.class);
    private static final String url = "jdbc:postgresql://localhost:5432/finance_controller_db";
    private static final String userName = "postgres";
    private static final String password = "postgres";

    @Override
    public List<Account> getAccounts() throws SQLException {

        List<Account> accountList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from account");
                while(resultSet.next()) {
                    accountList.add(new Account(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3)));
                    log.info("List of account was created");
                }
            }
        }
        return accountList;
    }

    @Override
    public List<Expense> getExpenses() throws SQLException {

        List<Expense> expenseList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from expense");
                while(resultSet.next()) {
                    expenseList.add(new Expense(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3)));
                    log.info("List of expenses was created");
                }
            }
        }
        return expenseList;
    }

    @Override
    public List<Income> getIncomes() throws SQLException {

        List<Income> incomeList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from income");
                while(resultSet.next()) {
                    incomeList.add(new Income(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3)));
                    log.info("List of incomes was created");
                }
            }
        }
        return incomeList;
    }

    @Override
    public List<Operation> getOperation() throws SQLException {

        List<Operation> operationList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from operation");
                while(resultSet.next()) {
                    operationList.add(new Operation(resultSet.getInt(1),
                            ((Timestamp)resultSet.getObject(2)).toInstant(),
                            resultSet.getInt(3)));
                    log.info("List of operations was created");
                }
            }
        }
        return operationList;
    }

    @Override
    public List<IncomeOperation> getIncomeOperation() throws SQLException {

        List<IncomeOperation> incomeOperationList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from income_operation");
                while(resultSet.next()) {
                    incomeOperationList.add(new IncomeOperation(resultSet.getInt(2),
                            resultSet.getInt(3)));
                    log.info("List of income_operations was created");
                }
            }
        }
        return incomeOperationList;
    }

    @Override
    public List<ExpenseOperation> getExpenseOperation() throws SQLException {

        List<ExpenseOperation> expenseOperationList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from expense_operation");
                while(resultSet.next()) {
                    expenseOperationList.add(new ExpenseOperation(resultSet.getInt(2),
                            resultSet.getInt(3)));
                    log.info("List of expense_operations was created");
                }
            }
        }
        return expenseOperationList;
    }

    @Override
    public List<User> getUsers() throws SQLException {

        List<User> userList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,userName,password)){
            log.info("Connection to data base");
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from users");
                while(resultSet.next()) {
                    userList.add(new User(resultSet.getInt(1),
                            resultSet.getString(3),
                            resultSet.getString(2)));
                    log.info("List of users was created");
                }
            }
        }
        return userList;
    }
}
