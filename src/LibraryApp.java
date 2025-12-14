import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public void run() {
        System.out.println("Welcome to Library App");

        while (true) {
            printMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addNewBook();
                case 3 -> searchBooksByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBookById();
                case 7 -> {
                    System.out.println("Good Bye!");
                    return;
                }
                default -> System.out.println("Invalid Choice.  Try again.");

            }

        }

    }
    // Menu
    private void printMenu() {

        System.out.println("""
                -------------------------
                1. Print all books
                2. Add new book
                3. Search books by title
                4. Borrow a book
                5. Return a book
                6. Delete a book by id
                7. Quit
                -------------------------
                """);
        System.out.print("Choose option: ");



    }
    // Functions
    private void printAllBooks() {
        if(books.isEmpty()) {
            System.out.println("There are no books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }

    }
    private void addNewBook() {
        try {
            System.out.println("Title:");
            String title = scanner.nextLine();

            System.out.println("Author:");
            String author = scanner.nextLine();

            System.out.println("Year:");
            int year = readInt();

            Book book = new Book(title, author, year);
            books.add(book);

            System.out.println("Book added successfully!");

        }  catch (IllegalArgumentException e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    private void searchBooksByTitle() {
        System.out.println("Enter part of Title:");
        String input = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(input)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }

    }

    private void borrowBook() {
        System.out.print("Enter Book ID: ");
        int id = readInt();

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isAvailable()) {
            book.markAsBorrowed();
            System.out.println("Book borrowed successfully!");
        } else  {
            System.out.println("Book not available.");
        }
    }

    private void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = readInt();

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            book.markAsReturned();
            System.out.println("Book returned successfully!");
        } else   {
            System.out.println("Book not available.");
        }
    }

    private void deleteBookById() {
        System.out.print("Enter book id: ");
        int id = readInt();

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);
        System.out.println("Book deleted.");
    }
    // Helpers
    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Please enter an integer: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;

    }



}
