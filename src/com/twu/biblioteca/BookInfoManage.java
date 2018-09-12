package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BookInfoManage {
    List<Book> bookList = new ArrayList<Book>();

    public BookInfoManage(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void printAllBooks(){
        System.out.println("All books in Biblioteca library");
        for (Book book : bookList) {
            System.out.println(book.getId()+" "+book.getName());
        }
    }


}
