package com.znaji.entity;

import jakarta.persistence.Entity;

@Entity
public class Book extends AbstractProduct{

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}
