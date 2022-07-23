package org.example;

import java.util.Scanner;

public class AdminMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void displayAdminMenu(Scanner scanner) {
        showAdminMenu();

    }

    private static void showAdminMenu() {
        System.out.println("Please select 1 to 4");
        System.out.println("1. Display Details of All Users");
        System.out.println("2. Delete a User");
        System.out.println("3. Change Admin Password");
        System.out.println("4. Logout");
    }
}
