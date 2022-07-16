package org.example.model;

import java.util.Date;

public class Transaction {
    private Date date;
    private String description;
    private double amount;
    private double balance;

    public Transaction(String description, double amount, double balance) {
        this.date = new Date();
        this.description = description;
        this.amount = amount;
        this.balance = balance;
    }



    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
