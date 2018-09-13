package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {
    private List<String> menuList = new ArrayList<>();
    private BookInfoManage bookInfoManage = new BookInfoManage();

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }


    public void printWelcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca library!");
    }


    public void handlerInputCommand(String userInput) {

        switch (userInput) {
            case "List Book":
                bookInfoManage.printAllBooks();
                break;
            case "Quit":
                System.exit(0);
                break;
            case "Checkout Book":
                System.out.println("please input book name which you want to borrow");
                int inputBookId = readFromConsole();
                bookInfoManage.checkoutBooks(inputBookId);
                break;
            default:
                System.out.println("Select a valid option");
        }

    }

    public void initMainMenu() {
        menuList.add("List Book");
        menuList.add("Quit");
        menuList.add("Checkout Book");

        for (String command : menuList) {
            System.out.println(command);
        }
    }

    public int readFromConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
