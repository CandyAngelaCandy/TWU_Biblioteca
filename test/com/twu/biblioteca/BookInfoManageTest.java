package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookInfoManageTest {
    BookInfoManage bookInfoManage;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    List<Book> bookList = new ArrayList<>();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));
        bookList.add(new Book(0,"Pride and Prejudice"," Jane Austen", Instant.parse("1995-10-23T10:12:35Z")));
        bookList.add(new Book(1,"The Red and the Black"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z")));
        bookList.add(new Book(2,"Harry Potter and the Philosopher’s Stone"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z")));
        bookList.add(new Book(3,"The Lord of the Rings"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z")));
        bookList.add(new Book(4,"The Great Gatsby"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z")));
        bookList.add(new Book(5,"The Diary Of A Young Girl"," Jane Austen",Instant.parse("1995-10-23T10:12:35Z")));

        bookInfoManage = new BookInfoManage(bookList);
    }

    @Test
    public void should_print_book_list(){
        bookInfoManage.printAllBooks();
        assertThat(bookInfoManage.printAllBooks(), is(bookList));
    }

}