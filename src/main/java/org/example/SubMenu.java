package org.example;

import org.example.enums.AccountType;
import org.example.model.Bank;
import org.example.model.User;
import org.example.services.implementations.AccountServiceImplementation;
import org.example.services.implementations.BankServiceImplementations;
import org.example.services.implementations.UserServiceImplementation;

import java.util.Scanner;

public class SubMenu {
    public static BankServiceImplementations bsi = BankServiceImplementations.getInstance();
    public static AccountServiceImplementation asi = AccountServiceImplementation.getInstance();
    public static UserServiceImplementation usi = UserServiceImplementation.getInstance();
    public static Bank bank = Bank.getInstance();
    private static String currentUserName = MainMenu.getName();


    static Scanner scanner = new Scanner(System.in);

    public static void displaySubMenu(Scanner scanner) {
        showSubMenu();
        int selection = -1;
        while (selection != 5) {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        //open new account
                        System.out.println("Do something for Sub Menu Option A");
                        createNewAccount();
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 2:
                        //view accounts
                        System.out.println("Do something for Sub Menu Option B");
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 3:
                        // deposit
                        System.out.println("Do something for Sub Menu Option C");
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 4:
                        // withdraw
                        System.out.println("Do something for Sub Menu Option D");
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 5:
                        // Transfer
                        System.out.println("Do something for Sub Menu Option E");
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 6:
                        // Show statement of account
                        System.out.println("Do something for Sub Menu Option F");
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 7:
                        System.out.println("Exit from menu now");
                        break;
                    default:
                        System.out.println("Please select 1 to 7");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Select from 1 to 7");
            }
        }
    }


    // open a new account

    private static void createNewAccount() {
        User user = bank.getCustomers().get(currentUserName);
        usi.createAccount(user, selectAccountType());
    }

    private static AccountType selectAccountType() {
        boolean invalid = true;
        int selection = -1;
        while (invalid) {
            try {
                System.out.println("1. Select CURRENT ACCOUNT");
                System.out.println("2. Select SAVING ACCOUNT");
                selection = Integer.parseInt(scanner.nextLine());
                if (selection == 1 || selection == 2) {
                    invalid = false;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Select 1 or 2");
            }
        }
        return selection == 1 ? AccountType.SAVINGS : AccountType.CURRENT;
    }

    private static void showSubMenu() {
        System.out.println("1. Open a new Account");
        System.out.println("2. View Accounts");
        System.out.println("3. Deposit");
        System.out.println("4. Withdrawal");
        System.out.println("5. Transfer");
        System.out.println("6. Show Statement of Account");
        System.out.println("7. Go back to the previous menu");

    }


    private static void displaySeparatorLine() {
        System.out.println("________________________________");
    }

}
