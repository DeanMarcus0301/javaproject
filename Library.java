package javaproject;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Shelf> shelves;
    List<Reader> readers;

    public Library() {
        this.shelves = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            shelves.add(new Shelf());
        }
        this.readers = new ArrayList<>();
    }

    public boolean isTherePlaceForNewBook() {
        for (Shelf shelf : shelves) {
            if (!shelf.isShelfFull()) {
                return true;
            }
        }
        return false;
    }

    public void addNewBook(Book book) {
        for (Shelf shelf : shelves) {
            if (!shelf.isShelfFull()) {
                shelf.addBook(book);
                return;
            }
        }
        System.out.println("Library is full. No space for new books.");
    }

    public void deleteBook(String title) {
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getTitle().equals(title)) {
                    shelf.getBooks().remove(book);
                    System.out.println("Book deleted successfully.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void registerReader(String name, int id) {
        readers.add(new Reader(id, name));
        System.out.println("Reader added successfully.");
    }

    public void removeReader(String name) {
        for (Reader reader : readers) {
            if (reader.getName().equals(name)) {
                readers.remove(reader);
                System.out.println("Reader removed successfully.");
                return;
            }
        }
        System.out.println("Reader not found.");
    }

    public List<String> searchByAuthor(String authorName) {
        List<String> bookTitles = new ArrayList<>();
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getAuthor().equals(authorName)) {
                    bookTitles.add(book.getTitle());
                }
            }
        }
        return bookTitles;
    }

    public void initializeLibrary() {
        for (Shelf shelf : shelves) {
            shelf.addBook(new Book("Author1", "Title1", 100));
            shelf.addBook(new Book("Author2", "Title2", 200));
        }
    }
}
