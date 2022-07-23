package org.example;

import org.example.services.implementations.BankServiceImplementations;

import java.util.Scanner;

/**
 * @author OkeyXimo 14/07/2022
 */
public class MainMenu {

    public static BankServiceImplementations bsi = BankServiceImplementations.getInstance();
    public static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu(Scanner scanner) {
        showMainMenu();
        int selection = -1;
        while (selection != 4) {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        createAccount();
                        showMainMenu();
                        displaySeparatorLine();
                        break;
                    case 2:
                        if (validateLogin()) {
                            SubMenu.displaySubMenu(scanner);
                        }
                        // show menu
                        showMainMenu();
                        break;
                    case 3:
                        // show admin panel adminUsername and password  is needed.
                        System.out.println("Do something for admin");
                        if (validateAdminLogin()){
                            AdminMenu.displayAdminMenu(scanner);
                        }
                        showMainMenu();
                        break;
                    case 4:
                        System.out.println("Exit from menu now");
                        break;
//                    case 5:
//                        //
//                        SubMenu.displaySubMenu(scanner);
//                        showMainMenu();
//                        break;
//                    default:
//                        System.out.println("Please select 1 to 4");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Select from 1 to 4");
            }
        }
    }

    // register
    private static void createAccount() {
        System.out.println("Enter your surname");
        String surname = nameValidator();
        System.out.println("Enter your first name");
        String firstname = nameValidator();
        System.out.println("Enter your email");
        String email = emailValidator();
        System.out.println("Enter a username");
        String username = nameValidator();
        System.out.println("Enter your password");
        String password = passwordValidator();
        bsi.createNewUser(surname, firstname, email, username, password);
    }

    // Login
    private static boolean validateLogin() {
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        return bsi.validateLogin(username, password);
    }

    // Helper Methods
    private static String nameValidator() {
        boolean invalid = true;
        String name = "";
        while (invalid) {
            name = scanner.nextLine();
            boolean result = bsi.nameValidator(name);
            if (result) {
                invalid = false;
            } else {
                System.out.println("Invalid entry, name must start with a Capital letter with a minimum 3 letters");
            }
        }
        return name;
    }

    private static String emailValidator() {
        boolean invalid = true;
        String email = "";
        while (invalid) {

            email = scanner.nextLine();
            boolean result = bsi.emailValidator(email);
            if (result) {
                invalid = false;
            } else {
                System.out.println("Invalid entry, enter a correct email format \"example@xyz.com\" ");
            }
        }
        return email;
    }

    private static String passwordValidator() {
        boolean invalid = true;
        String password = "";
        while (invalid) {
            password = scanner.nextLine();
            boolean result = bsi.passwordValidator(password);
            if (result) {
                invalid = false;
            } else {
                System.out.println("Invalid password format, password must be a minimum of 6 characters, containing an uppercase, a number and a special character");
            }
        }
        return password;
    }


    private static void displaySeparatorLine() {
        System.out.println("________________________________");
    }

    private static void showMainMenu() {
        System.out.println("Please select 1 to 3");
        System.out.println("1. Sign up");
        System.out.println("2. Sign In");
        System.out.println("3. Admin Login");
        System.out.println("4. To Quit");
//        System.out.println("5. To debug");
    }

    private static boolean validateAdminLogin(){
        return false;
    }
}

