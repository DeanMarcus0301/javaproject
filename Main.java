package javaproject;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.initializeLibrary(); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("For adding a book - Press 1");
            System.out.println("For deleting a book - Press 2");
            System.out.println("For registering a new reader - Press 3");
            System.out.println("For removing a reader - Press 4");
            System.out.println("For searching books by author - Press 5");
            System.out.println("For exit - Press 6");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if(library.isTherePlaceForNewBook()) {
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter number of pages: ");
                        int pages = scanner.nextInt();
                        scanner.nextLine();
                        library.addNewBook(new Book(author, title, pages));
                    }
                    else {
                        System.out.println("There is not place for another book");
                    }
                    break;
                case 2:
                    System.out.print("Enter book title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    library.deleteBook(deleteTitle);
                    break;
                case 3:
                    System.out.print("Enter reader name: ");
                    String readerName = scanner.nextLine();
                    System.out.print("Enter reader ID: ");
                    int readerId = scanner.nextInt();
                    scanner.nextLine();
                    library.registerReader(readerName, readerId);
                    break;
                case 4:
                    System.out.print("Enter reader name to remove: ");
                    String removeReaderName = scanner.nextLine();
                    library.removeReader(removeReaderName);
                    break;
                case 5:
                    System.out.print("Enter author name to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<String> authorBooks = library.searchByAuthor(searchAuthor);
                    if (authorBooks.isEmpty()) {
                        System.out.println("No books found for this author.");
                    } else {
                        System.out.println("Books by " + searchAuthor + ":");
                        for (String bookTitle : authorBooks) {
                            System.out.println("- " + bookTitle);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
