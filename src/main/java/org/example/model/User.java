package org.example.model;

//import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.*;
import java.util.regex.Pattern;

public class User {
    private String surname;
    private String firstname;
    private String email;
    private String password;
    private String username;
    private String accountNumber;



    private final Map<String, Account> userAccounts;
    private List<String> accountNumberTracker;

    /* CONSTRUCTOR GETTERS AND SETTERS */

    public User(String surname, String firstname, String email, String password, String username) {
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.userAccounts = new LinkedHashMap<>();
        this.accountNumberTracker = new ArrayList<>();
    }

    public User() {
        this.userAccounts = new HashMap<>();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Account> getUserAccounts() {
        return userAccounts;
    }

    public String getFullName(){
//        String
        return firstname + " " + surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    /* Temporary */
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<String> getAccountNumberTracker() {
        return accountNumberTracker;
    }
}
