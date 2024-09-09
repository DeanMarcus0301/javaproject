package javaproject;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    List<Book> books;
    boolean isShelfFull;

    public Shelf() {
        this.books = new ArrayList<>(5);
        this.isShelfFull = false;
    }

    public void addBook(Book book) {
        if (books.size() < 5) {
            books.add(book);
            isShelfFull = books.size() == 5;
            System.out.println("New Book added successfully.");
        } else {
            System.out.println("Shelf is full.");
        }
    }

    public void replaceBooks(int num1, int num2) {
        if (num1 < 1 || num1 > 5 || num2 < 1 || num2 > 5) {
            System.out.println("Invalid numbers. Please enter numbers between 1 and 5.");
            return;
        }

        int pos1 = num1 - 1;
        int pos2 = num2 - 1;

        if (books.get(pos1) == null || books.get(pos2) == null) {
            System.out.println("One or both positions are empty.");
            return;
        }

        Book temp = books.get(pos1);
        books.set(pos1, books.get(pos2));
        books.set(pos2, temp);
        System.out.println("Books replaced successfully.");
    }


    public boolean isShelfFull() {
        return isShelfFull;
    }

    public List<Book> getBooks() {
        return books;
    }
}
