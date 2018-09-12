package com.twu.biblioteca;

import java.time.Instant;

public class Book {
    private String name;
    private int id;
    private String author;
    private Instant published;

    public Book(int id, String name, String author, Instant published) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.published = published;
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
