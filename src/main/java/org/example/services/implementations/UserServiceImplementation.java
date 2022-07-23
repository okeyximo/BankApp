package org.example.services.implementations;

import org.example.enums.AccountType;
import org.example.model.Account;
import org.example.model.Bank;
import org.example.model.User;
import org.example.services.IUserServiceImplementation;

import java.util.Random;


public class UserServiceImplementation implements IUserServiceImplementation {
    Bank bank = Bank.getInstance();
    private static final UserServiceImplementation SINGLE_INSTANCE = new UserServiceImplementation();

    private UserServiceImplementation() {
    }

    public static UserServiceImplementation getInstance() {
        return SINGLE_INSTANCE;
    }

    private String generateAccountNumber() {
        Random objGenerator = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        for (int i = 0; i < 8; i++) {
            int randomNumber = objGenerator.nextInt(10);
            sb.append(randomNumber);
        }
//        return (bank.getAccountNumbers().containsKey(sb.toString())) ? generateAccountNumber() : sb.toString();
        return sb.toString();
    }

    @Override
    public void createAccount(User user, AccountType accountType) {
        Account newAccount = new Account();
        String username = user.getUsername();
        if (bank.getCustomers().containsKey(username)){
            newAccount.setAccountName(user.getFullName());
            String accountNumber = generateAccountNumber();
            newAccount.setAccountNumber(accountNumber);
            newAccount.setAccountType(accountType);
            newAccount.setAccountBalance(0.0);
            user.setAccountNumber(accountNumber); // temporary
            user.getUserAccounts().put(newAccount.getAccountNumber(), newAccount);
            user.getAccountNumberTracker().add(accountNumber);
            bank.getAccountNumbers().put(newAccount.getAccountNumber(), user);
            System.out.println("Your account opening is successful.\nHere is your account number " + accountNumber);
        }
        else {
            System.out.println("Register first");
        }
    }
}
