package org.example.financialcontroller.hibernate.main;

import org.example.financialcontroller.hibernate.dao.impl.*;
import org.example.financialcontroller.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.Instant;
import java.util.Scanner;

public class HibernateMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Configuration configuration = new Configuration().configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();
        ) {

            AccountDaoImpl account = new AccountDaoImpl(session);

            UserDaoImpl user = new UserDaoImpl(session);

            System.out.println("Enter your name: ");
            String userName = scanner.next();

            System.out.println("Enter your phone number: ");
            String phoneNumber = scanner.next();

            if(!user.isUserExists(userName, phoneNumber)) {
                throw new Exception("User does not exist.");
            }

            long userId = user.getUserId(userName, phoneNumber);

            System.out.println("Enter type of operation: ");
            System.out.println();


            System.out.println("Select account_id to add operation: ");
            for(Account item :  account.getAccountsByUserId(userId)){
                System.out.println("Id : " + item.getId() + " - " +  item.getName());
            }

            long selectedAccountId = scanner.nextInt();

            System.out.println("\nSelect type of operation : \n1 - Income\n2 - Expense");

            Operation operation = new Operation();
            operation.setAccount(account.findById(selectedAccountId));
            operation.setTimestamp(Instant.now());

            OperationDaoImpl opi = new OperationDaoImpl(session);
            opi.create(operation);

            int selectedTypeOfOperation = scanner.nextInt();

            if(selectedTypeOfOperation == 1) {
                int answer = -1 ;
                IncomeDaoImpl incomeDao = new IncomeDaoImpl(session);
                IncomeOperationsDaoImpl incomesOperationsDao = new IncomeOperationsDaoImpl(session);
                do {
                    System.out.println("Enter income type : ");
                    String incomeType = scanner.next();
                    System.out.println("Enter income sum : ");
                    int incomeSum = scanner.nextInt();

                    Income income = new Income();
                    income.setAmount(incomeSum);
                    income.setTypeOfIncomes(incomeType);

                    incomeDao.create(income);


                    IncomeOperations incomesOperations = new IncomeOperations();
                    incomesOperations.setIncomeId(income);
                    incomesOperations.setOperationId(operation);

                    incomesOperationsDao.create(incomesOperations);

                    System.out.println("Add another income ? \n1 - yes\n0 - no");
                    answer = scanner.nextInt();

                }while (answer > 0);
                System.out.println("\n");
            } else {
                int answer = 0;
                ExpenseDaoImpl expenseDao = new ExpenseDaoImpl(session);
                ExpenseOperationsDaoImpl expenseOperationsDao = new ExpenseOperationsDaoImpl(session);
                do{
                    System.out.println("Enter expense type: ");
                    String expenseType = scanner.next();
                    System.out.println("Enter expense sum: ");
                    int expenseSum = scanner.nextInt();

                    Expense expense = new Expense();
                    expense.setAmount(expenseSum);
                    expense.setTypeOfExpenses(expenseType);

                    expenseDao.create(expense);

                    ExpenseOperations expenseOperations = new ExpenseOperations();
                    expenseOperations.setExpenseId(expense);
                    expenseOperations.setOperationId(operation);

                    expenseOperationsDao.create(expenseOperations);
                    System.out.println("Add another expense? \n1 - yes\n0 - no");
                    answer = scanner.nextInt();

                }while (answer > 0);
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
