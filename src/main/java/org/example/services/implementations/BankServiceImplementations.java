package org.example.services.implementations;

import org.example.model.Bank;
import org.example.model.User;
import org.example.services.IBankServiceImplementation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankServiceImplementations implements IBankServiceImplementation {

    Bank bank = Bank.getInstance();
    private static final BankServiceImplementations SINGLE_INSTANCE = new BankServiceImplementations();


    private BankServiceImplementations() {
    }

    /* SINGLETON CLASS */
    public static BankServiceImplementations getInstance() {
        return SINGLE_INSTANCE;
    }

    /* BSI methods */

    public boolean validateLogin(String username, String password) {
        if (this.bank.getCustomers().containsKey(username) && this.bank.getCustomers().get(username).getPassword().equals(password)) {
            System.out.println("Successful Login");
            bank.getTrackLogin().add(username);
            System.out.println(username + " ********");
            return true;
        }
        System.out.println("Invalid UserName or password");
        return false;
    }

    public boolean passwordValidator(String password) {
        String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean emailValidator(String email) {
        String EMAIL_PATTERN = "^[A-Za-z\\d+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean nameValidator(String name) {
        String NAME_PATTERN = "^[A-Z]\\w{2,29}$";
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * checks if the username is already used in the database
     *
     * @param username of customer
     * @return false if it exists and true if it does not exist.
     */
    public boolean usernameValidator(String username) {
        if (bank.getCustomers().containsKey(username)) {
            System.out.println("Username already exist");

            return false;
        }

        return true;
    }

    @Override
    public void createNewUser(String surname, String firstName, String email, String userName, String password) {
        if (usernameValidator(userName)) {
            User newUser = new User(surname, firstName, email, password, userName);
            this.bank.getCustomers().put(userName, newUser);
            System.out.println("Welcome to our bank " + newUser.getFullName());
        }
    }

    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
//        setTimeout(() -> System.out.println("test"), 5000);
    }
}
