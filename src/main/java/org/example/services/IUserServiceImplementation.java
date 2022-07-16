package org.example.services;

import org.example.enums.AccountType;
import org.example.model.User;

public interface IUserServiceImplementation {
    void createAccount(User user, AccountType accountType);



}
