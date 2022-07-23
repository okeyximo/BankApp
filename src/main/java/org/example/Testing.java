package org.example;

import org.example.enums.AccountType;
import org.example.model.Bank;
import org.example.model.User;
import org.example.services.implementations.AccountServiceImplementation;
import org.example.services.implementations.BankServiceImplementations;
import org.example.services.implementations.UserServiceImplementation;

public class Testing {
    public static void main(String[] args) {
        AccountServiceImplementation asi = AccountServiceImplementation.getInstance();
        BankServiceImplementations bsi = BankServiceImplementations.getInstance();
        UserServiceImplementation usi = UserServiceImplementation.getInstance();
        Bank bank = Bank.getInstance();

        /* Registration */
        bsi.createNewUser("Ok", "Chks", "x@gmail.com", "okx", "@1234qwer");
        bsi.createNewUser("Cj", "Jay", "y@gmail.com", "pet", "@1234q");

        System.out.println(bank.getCustomers());
        User u1 = bank.getCustomers().get("okx");
        User u2 = bank.getCustomers().get("pet");

        System.out.println(u2);
        //test login
        System.out.println(bsi.validateLogin("pet", "@1234q"));

// opening of account
        usi.createAccount(u2, AccountType.SAVINGS);
        usi.createAccount(u1, AccountType.CURRENT);
        usi.createAccount(u1, AccountType.CURRENT);
        usi.createAccount(u1, AccountType.SAVINGS);
// deposit
        asi.deposit(u2, "October savings", 2000.0, u2.getAccountNumber());
        asi.deposit(u2, "flexing", 1000.0, u2.getAccountNumber());
// transfer
        asi.transfer(u2, u2.getUserAccounts().get(u2.getAccountNumber()), u1.getAccountNumber(), 1500.0, "urgent 1k5");

        asi.getStatementOfAccount(u2.getUserAccounts().get(u2.getAccountNumber()));
        asi.getStatementOfAccount(u1.getUserAccounts().get(u1.getAccountNumber()));
        asi.getStatementOfAccount(u2.getUserAccounts().get(u2.getAccountNumber()));
        asi.getAccountDetails(u1);
//        asi.selectAccount(u1);
//        asi.getStatementOfAccount(u1.getUserAccounts().get(u1.getAccountNumber()));


    }


}
