package com.twu.biblioteca;

import java.time.Instant;

public class Book {
    private String name;
    private int id;
    private String author;
    private Instant published;
    private boolean borrow;
    private String userId = "";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public Book(int id, String name, String author, Instant published, boolean borrow) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.published = published;
        this.borrow = borrow;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.name.equals(book.name)
                    && this.id == book.id
                    && this.author.equals(book.author)
                    && this.published.equals(book.published);
        }
        return false;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instant getPublished() {
        return published;
    }

    public void setPublished(Instant published) {
        this.published = published;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
