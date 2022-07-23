package org.example.Helpers;

import org.example.model.Bank;
import org.example.model.User;
import org.example.services.implementations.AccountServiceImplementation;
import org.example.services.implementations.BankServiceImplementations;
import org.example.services.implementations.UserServiceImplementation;

import static org.example.MainMenu.scanner;


public class SubMenuHelpers {
    public static BankServiceImplementations bsi = BankServiceImplementations.getInstance();
    public static AccountServiceImplementation asi = AccountServiceImplementation.getInstance();
    public static UserServiceImplementation usi = UserServiceImplementation.getInstance();
    public static Bank bank = Bank.getInstance();
    private static final SubMenuHelpers SINGLE_INSTANCE = new SubMenuHelpers();

    public static SubMenuHelpers getInstance() {
        return SINGLE_INSTANCE;
    }

    public double typeAmount() {
        // handle not a input mismatch exception
        double amount;
        while (true) {
            try {
                double input = scanner.nextDouble();
                if (input <= 0) {
                    System.out.println("Invalid amount");
                } else {
                    amount = input;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type a number");
            }
        }
        return amount;
    }

    public int selectAccount(User user) {
        int selectedNumber;
        while (true) {
            try {
                System.out.println("Select account you want to use to perform the transaction");
                viewAccounts();
                int selection = scanner.nextInt();
                int maxSelection = user.getAccountNumberTracker().size();
                if (selection > 0 && selection <= maxSelection) {
                    selectedNumber = selection;
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Select account you want to use to perform the transaction");
            }
        }
        return selectedNumber;
    }

    public void viewAccounts() {
        String currentUserName = bank.getTrackLogin().get(0);
        User user = bank.getCustomers().get(currentUserName);
        asi.getAccountDetails(user);
    }

    public int selectAccountType() {
        int selection = -1;
        while (true) {
            try {
                System.out.println("1. Select CURRENT ACCOUNT");
                System.out.println("2. Select SAVING ACCOUNT");
                System.out.println("3. RETURN TO PREVIOUS MENU");
                selection = scanner.nextInt();
                if (selection > 0 && selection <= 3) {
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Select 1 to 3");
            }
        }
        return selection;
    }
    public String enterAccountNumber() {
        String accountNumber;
        while (true) {
            try {
                String input = scanner.next();
                if (input.length() == 10) {
                    accountNumber = input;
                    break;
                } else {
                    System.out.println("Enter the 10 digit account number of the receiver");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter the 10 digit account number of the receiver");
            }
        }
        return accountNumber;
    }
}
