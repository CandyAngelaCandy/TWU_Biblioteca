package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class BookInfoManageTest {
    BookInfoManage bookInfoManage = new BookInfoManage();
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    List<Book> bookList = new ArrayList<>();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));

        bookList.add(new Book(0, "Pride and Prejudice", " Jane Austen", Instant.parse("1995-10-23T10:12:35Z"), false));
        bookList.add(new Book(1, "The Red and the Black", " Jane Austen", Instant.parse("1995-10-23T10:12:35Z"), false));
        bookList.add(new Book(2, "Harry Potter and the Philosopher’s Stone", " Jane Austen", Instant.parse("1995-10-23T10:12:35Z"), false));
        bookList.add(new Book(3, "The Lord of the Rings", " Jane Austen", Instant.parse("1995-10-23T10:12:35Z"), false));
        bookList.add(new Book(4, "The Great Gatsby", " Jane Austen", Instant.parse("1995-10-23T10:12:35Z"), false));
        bookList.add(new Book(5, "The Diary Of A Young Girl", " Jane Austen", Instant.parse("1995-10-23T10:12:35Z"), false));

    }

    @Test
    public void should_print_book_list() {
        assertThat(bookInfoManage.printAllBooks(), is(bookList));
    }

    @Test
    public void should_update_book_when_check_out_book() {
         bookList =  this.bookList.stream().map((book) ->{
            if(book.getId() == 0) book.setBorrow(true);
            return book;
        } ).collect(Collectors.toList());

        bookInfoManage.checkoutBooks(0);
        assertThat(bookInfoManage.getBookList(), is(bookList));
        assertThat(outputContent.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shoud_print_not_available_when_book_not_exist() {
        bookInfoManage.checkoutBooks(6);
        assertThat(outputContent.toString(), containsString("That book is not available"));
    }

}