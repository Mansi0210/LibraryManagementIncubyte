package com.libmgmt.service;

import com.libmgmt.model.Book;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> booklist = new ArrayList<>();

    public boolean addBook(Book book) {
        boolean isvalid = validate(book.getIsbn());
        if (isvalid) {
            booklist.add(book);
            return true;
        } else {
            return false;
        }

    }

    public boolean validate(String isbn) {
        for (int i = 0; i < booklist.size(); i++) {
            Book b = booklist.get(i);
            if (b.getIsbn().equals(isbn)) {
                return false;
            }
        }
        return true;
    }


}
