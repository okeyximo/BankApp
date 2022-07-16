package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {


    private Map<String, User> customers;
    private Map<String, User> accountNumbers;
    private static Bank single_instance = null;


    /* CONSTRUCTOR , GETTERS AND SETTERS */
    private Bank() {
        this.customers = new HashMap<>();
        this.accountNumbers = new HashMap<>();
    }

    public static Bank getInstance() {

        if (single_instance == null)
            single_instance = new Bank();

        return single_instance;
    }

    public Map<String, User> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, User> customers) {
        this.customers = customers;
    }

    public Map<String, User> getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(Map<String, User> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }
}
