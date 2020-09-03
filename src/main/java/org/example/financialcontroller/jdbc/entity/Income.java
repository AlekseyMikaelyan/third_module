package org.example.financialcontroller.jdbc.entity;

public class Income {
    public int id;
    public int amount;
    public String typeOfIncome;

    public Income(int id , String typeOfIncome, int amount) {
        this.amount = amount;
        this.typeOfIncome = typeOfIncome;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Income{" +
                "sumOfIncome=" + amount +
                ", typeOfIncome='" + typeOfIncome + '\'' +
                '}';
    }

    public String[] toCSVFormat(){
        String[] csvIncome = new String[4];
        csvIncome[0] = "Income";
        csvIncome[1] = "" + id;
        csvIncome[2] = "" + amount;
        csvIncome[3] = typeOfIncome;

        return csvIncome;
    }
}
