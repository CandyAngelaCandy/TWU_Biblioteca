package com.twu.biblioteca;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookInfoManage {
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookInfoManage() {
        initBooksList();
    }

    public void initBooksList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(0,"Pride and Prejudice"," Jane Austen", Instant.parse("1995-10-23T10:12:35Z"),false));
        bookList.add(new Book(1,"The Red and the Black"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z"),false));
        bookList.add(new Book(2,"Harry Potter and the Philosopher’s Stone"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z"),false));
        bookList.add(new Book(3,"The Lord of the Rings"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z"),false));
        bookList.add(new Book(4,"The Great Gatsby"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z"),false));
        bookList.add(new Book(5,"The Diary Of A Young Girl"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z"),false));
        this.bookList = bookList;
    }

    public List<Book> printAllBooks(){
        System.out.println("All books in Biblioteca library");

        this.bookList.stream().filter((book) -> !book.isBorrow()).forEach((book) ->{
            System.out.println(book.getId()+" "+book.getName());
        });

        return this.bookList;
    }

    public void checkoutBooks(int id) {

        this.bookList =  this.bookList.stream().map((book) ->{
            if(book.getId() == id) book.setBorrow(true);
            return book;
        } ).collect(Collectors.toList());
    }

    public String readFromConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
