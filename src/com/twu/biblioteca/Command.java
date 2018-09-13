package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {
    private List<String> menuList = new ArrayList<>();

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }


    public void printWelcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca library!");
    }


    public void inputCommand(String userInput) {

        switch (userInput) {
            case "List Book":
                System.out.println("list book");
                break;
            case "Quit":
                System.exit(0);
            default:
                System.out.println("Select a valid option");
        }

    }

    public void initMainMenu() {
        menuList.add("List Book");
        menuList.add("Quit");

        for (String command : menuList) {
            System.out.println(command);
        }
    }

}
