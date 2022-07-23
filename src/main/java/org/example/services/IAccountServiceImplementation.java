package org.example.services;

import org.example.model.Account;
import org.example.model.User;

public interface IAccountServiceImplementation {
    void deposit(User user, String description, Double amount, String accountNumber);

    void withdraw(User user, String description, Double amount, String accountNumber);

    void transfer(User user1, String accountNumber, String user2accountNumber, double amount, String description);

    void getStatementOfAccount(User user, String accountNumber);

}
