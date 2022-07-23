package org.example;

import org.example.enums.AccountType;
import org.example.model.Bank;
import org.example.model.User;
import org.example.services.implementations.AccountServiceImplementation;
import org.example.services.implementations.BankServiceImplementations;
import org.example.services.implementations.UserServiceImplementation;
import org.example.Helpers.SubMenuHelpers;

import java.util.Scanner;

public class SubMenu {
    public static BankServiceImplementations bsi = BankServiceImplementations.getInstance();
    public static AccountServiceImplementation asi = AccountServiceImplementation.getInstance();
    public static UserServiceImplementation usi = UserServiceImplementation.getInstance();
    public static SubMenuHelpers helpers = SubMenuHelpers.getInstance();
    public static Bank bank = Bank.getInstance();
    private static String currentUserName;

    static Scanner scanner = new Scanner(System.in);

    public static void displaySubMenu(Scanner scanner) {
        showSubMenu();
        int selection = -1;
        while (selection != 7) {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        // open new account
                        createNewAccount();
                        // set timeout -> display account details in table
                        displaySeparatorLine();
                        showSubMenu();
                        // debugging
                        System.out.println(bank.getCustomers().get(currentUserName));
                        break;
                    case 2:
                        // view accounts
                        helpers.viewAccounts();
                        displaySeparatorLine();
                        showSubMenu();
                        break;
                    case 3:
                        // deposit
                        System.out.println("Do something for Sub Menu Option C");
                        deposit();
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
                        displayAllAccount();
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
                        bank.getTrackLogin().remove(0);
                        break;
                    default:
                        System.out.println("Please select 1 to 7");
                        showSubMenu();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Select from 1 to 7");
            }
        }
    }

    // open a new account
    private static void createNewAccount() {
        currentUserName = bank.getTrackLogin().get(0);
        User user = bank.getCustomers().get(currentUserName);
        AccountType accountType;
        int selectAccount = helpers.selectAccountType();
        if (selectAccount == 1) {
            accountType = AccountType.CURRENT;
        } else if (selectAccount == 2) {
            accountType = AccountType.SAVINGS;
        } else {
            return;
        }
        usi.createAccount(user, accountType);
    }

    // deposit
    private static void deposit() {
        currentUserName = bank.getTrackLogin().get(0);
        User user = bank.getCustomers().get(currentUserName);
        int selectedNumber = 0;
        double amountToBeDeposited = 0;
        String description;
        if (user.getAccountNumberTracker().size() == 0) {
            System.out.println("You have not opened any account yet");
            return;
        }
        System.out.println("How much do you want to deposit");
        amountToBeDeposited = helpers.typeAmount();
        System.out.println("Enter the transaction description");
        scanner.nextLine();
        description = scanner.nextLine();
        selectedNumber = helpers.selectAccount(user);
        asi.deposit(user, description, amountToBeDeposited, asi.selectAccount(user, selectedNumber));
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

    /* Debugging Start */
    public static void displayAllAccount() {
        for (User user : bank.getCustomers().values()) {
            System.out.println(user.toString());
        }
    }


    // mock data
    public static void mockUsers() {
        bsi.createNewUser("Ok", "Chks", "x@gmail.com", "okx", "@1234qwer");
        bsi.createNewUser("Cj", "Jay", "y@gmail.com", "pet", "@1234q");
        bank.getTrackLogin().add("pet");
    }
}
