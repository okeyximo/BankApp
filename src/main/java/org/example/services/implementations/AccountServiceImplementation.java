package org.example.services.implementations;

import org.example.enums.AccountType;
import org.example.model.Account;
import org.example.model.Bank;
import org.example.model.Transaction;
import org.example.model.User;
import org.example.services.IAccountServiceImplementation;

import java.util.Map;


public class AccountServiceImplementation implements IAccountServiceImplementation {

    public static AccountServiceImplementation SINGLE_INSTANCE = new AccountServiceImplementation();

    private AccountServiceImplementation() {
    }

    public static AccountServiceImplementation getInstance() {
        return SINGLE_INSTANCE;
    }

    /* ASI methods */
    Bank bank = Bank.getInstance();

    public boolean deposit(User user, String description, Double amount, String accountNumber) {
        if (user.getUserAccounts().containsKey(accountNumber)) {
            Account userAccount = user.getUserAccounts().get(accountNumber);
            Double previousBalance = userAccount.getAccountBalance();
            userAccount.setAccountBalance(previousBalance + amount);
            Transaction transaction = new Transaction(description, amount, userAccount.getAccountBalance());
            userAccount.getTransactionList().add(transaction);
            System.out.println("Transaction Successful");
            return true;
        }
        System.out.println("Transaction failed");
        return false;
    }

    //to be modified
    public boolean transfer(User user1, Account account, String user2accountNumber, double amount, String description) {
        if (validateTransaction(account, amount)) {
            if (bank.getAccountNumbers().containsKey(user2accountNumber)) {
                User user2 = bank.getAccountNumbers().get(user2accountNumber);
                Account user2Account = user2.getUserAccounts().get(user2accountNumber);

                double user2previousBalance = user2Account.getAccountBalance();
                double user1previousBalance = account.getAccountBalance();
                user2Account.setAccountBalance(user2previousBalance + amount);
                account.setAccountBalance(user1previousBalance - amount);

//                Transaction transactionSender = new Transaction(description, amount, user1Account.getAccountBalance() ); //temporary
                Transaction transactionReceiver = new Transaction("CREDIT! " + description, amount, user2Account.getAccountBalance());

                bank.getAccountNumbers().get(user2accountNumber).getUserAccounts().get(user2accountNumber).getTransactionList().add(transactionReceiver);

                System.out.println("Transaction Successful");
                return true;
            }
        }
        System.out.println("Transaction Failed");
        return false;

    }

    /* to be modified*/
    public String checkBalance(User user) {
        return null;
    }

    public void getStatementOfAccount(Account account) {
        for (Transaction transaction : account.getTransactionList()) {
            System.out.println(transaction.toString());
        }
    }

    public void getAccountDetails(User user) {
        for (Map.Entry<String, Account> entry : user.getUserAccounts().entrySet()) {
            System.out.println(user.getFullName() + entry.getKey() + ":" + +entry.getValue().getAccountBalance());
        }
    }

    private boolean validateTransaction(Account account, Double amount) {
        if (account.getAccountType() == AccountType.SAVINGS) {
            if ((account.getAccountBalance() - amount) >= 1000) {
                return true;
            }
        }
        return (account.getAccountBalance() >= amount);
    }
}
