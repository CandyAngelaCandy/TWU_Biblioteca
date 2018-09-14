package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {
    private List<String> menuList = new ArrayList<>();
    private BookInfoManage bookInfoManage = new BookInfoManage();
    private MovieInfoManage movieInfoManage = new MovieInfoManage();

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
            case "List Movie":
                movieInfoManage.printAllMovie();
                break;
            case "Quit":
                System.exit(0);
                break;
            case "Checkout Book":
                System.out.println("please input book ID which you want to borrow");
                int checkoutBookId = readFromConsole();
                bookInfoManage.checkoutBooks(checkoutBookId);
                break;
            case "Checkout Movie":
                System.out.println("please input movie ID which you want to borrow");
                int checkoutMovieId = readFromConsole();
                movieInfoManage.checkoutMovies(checkoutMovieId);
                break;
            case "return Book":
                System.out.println("please input book ID which you want to return");
                int returnBookId = readFromConsole();
                bookInfoManage.returnBook(returnBookId);
                break;
            default:
                System.out.println("Select a valid option");
        }

    }

    public void initMainMenu() {
        menuList.add("List Book");
        menuList.add("List Movie");
        menuList.add("Checkout Book");
        menuList.add("Checkout Movie");
        menuList.add("return Book");
        menuList.add("return Movie");
        menuList.add("Quit");

        for (String command : menuList) {
            System.out.println(command);
        }
    }

    public int readFromConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
