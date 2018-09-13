package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Command command = new Command();
        command.printWelcomeMessage();
        System.out.println("main menu command:");

        command.initMainMenu();

        System.out.println("\nplease select commond:");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        command.inputCommand(userInput);
    }
}
