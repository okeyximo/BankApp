package org.example.services;

import org.example.model.User;

public interface IBankServiceImplementation {
    void createNewUser(String firstName, String lastName, String email, String userName, String password);
}
