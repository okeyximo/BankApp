package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu.displayMainMenu(scanner);
        if (scanner != null)
            scanner.close();
    }
}



