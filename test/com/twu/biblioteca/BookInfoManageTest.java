package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class BookInfoManageTest {
    BookInfoManage bookInfoManage;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(0,"Pride and Prejudice"));
        bookList.add(new Book(1,"The Red and the Black"));
        bookList.add(new Book(2,"Harry Potter and the Philosopher’s Stone"));
        bookList.add(new Book(3,"The Lord of the Rings"));
        bookList.add(new Book(4,"The Great Gatsby"));
        bookList.add(new Book(5,"The Diary Of A Young Girl"));

        bookInfoManage = new BookInfoManage(bookList);
    }

    @Test
    public void should_print_book_list(){
        bookInfoManage.printAllBooks();
        assertThat(outputContent.toString(), containsString("Pride and Prejudice"));
        assertThat(outputContent.toString(), containsString("The Red and the Black"));
        assertThat(outputContent.toString(), containsString("Harry Potter and the Philosopher’s Stone"));

    }

}