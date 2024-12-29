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

    public boolean borrowBook(String isbn) throws Exception {
        boolean isavailable = availableBook(isbn);
        boolean bookFound = false;
        if (isavailable == false) {
            throw new Exception("Book Not Found");
        }
        for (int i = 0; i < booklist.size(); i++) {
            Book b = booklist.get(i);
            if (b.getIsbn().equals(isbn) && b.isAvailable()==true ) {
                b.setAvailable(false);
                booklist.set(i, b);
                bookFound = true;
                break;
            }
        }

        return bookFound;
    }
    public boolean availableBook(String isbn){
        for(Book b : booklist){
            if(b.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String isbn) throws Exception{
        boolean isavailable = availableBook(isbn);
        boolean bookFound = false;
        if(isavailable == false){
            throw new Exception("Book Not Found");
        }

        for(int i=0; i<booklist.size();i++){
            Book b = booklist.get(i);
            if(b.getIsbn().equals(isbn) && b.isAvailable()==false ){
                b.setAvailable(true);
                bookFound = true;
                break;
            }
        }
        return bookFound;
    }

    public ArrayList<Book> viewAvailableBook(){
        ArrayList<Book> availableBooks = new ArrayList<>();
        for(Book b: booklist){
            if(b.isAvailable()){
                availableBooks.add(b);
            }
        }
        return availableBooks;
    }

}
