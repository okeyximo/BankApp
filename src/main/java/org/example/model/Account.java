package org.example.model;

import org.example.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountName;
    private String accountNumber;
    private AccountType accountType;
    private double accountBalance;
    private List<Transaction> transactionList;


    public Account() {
        this.transactionList = new ArrayList<>();
    }

    public Account(String accountName, AccountType accountType, double accountBalance) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.transactionList = new ArrayList<>();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", transactionList=" + transactionList +
                '}';
    }
}
