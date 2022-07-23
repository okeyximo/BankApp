package org.example.model;

import java.util.*;

public class Bank {

    private Map<String, User> customers;
    private Map<String, User> accountNumbers;
    private List<String> trackLogin;
    private static Bank single_instance = null;
    private String adminUserName = "okeyximo";
    private String adminPassword = "123456";

    /* CONSTRUCTOR , GETTERS AND SETTERS */
    private Bank() {
        this.customers = new HashMap<>();
        this.accountNumbers = new HashMap<>();
        this.trackLogin = new LinkedList<>();
    }

    public static Bank getInstance() {

        if (single_instance == null)
            single_instance = new Bank();

        return single_instance;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
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

    public List<String> getTrackLogin() {
        return trackLogin;
    }

    public void setTrackLogin(List<String> trackLogin) {
        this.trackLogin = trackLogin;
    }
}
