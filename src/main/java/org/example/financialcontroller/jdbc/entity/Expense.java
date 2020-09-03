package org.example.financialcontroller.jdbc.entity;

public class Expense {
    public int id;
    public int amount;
    public String typeOfExpenses;

    public Expense(int id , int amount, String typeOfExpenses){
        this.amount = amount;
        this.typeOfExpenses = typeOfExpenses;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                "amount=" + amount +
                ", typeOfExpenses='" + typeOfExpenses + '\'' +
                '}';
    }

    public String[] toCSVFormat(){
        String[] csvExpense = new String[4];
        csvExpense[0] = "Expense";
        csvExpense[1] = "" + id;
        csvExpense[2] = "" + amount;
        csvExpense[3] = typeOfExpenses;

        return csvExpense;
    }
}
