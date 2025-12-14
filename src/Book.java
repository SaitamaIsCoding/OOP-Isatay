import java.time.Year;

public class Book {

    // Fields
    private int id;
    private static int idGen;
    private String title;
    private String author;
    private int year;
    private boolean available;

    // Constructors
    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    // Getters
    public int getId() {
        return id;
    }

    public static int getIdGen() {
        return idGen;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author must not be null or empty");
        }
        this.author = author;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1500 || year > currentYear) {
            throw new IllegalArgumentException(
                    "Year must be between 1500 and " + currentYear
            );
        }
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Methods
    public void markAsBorrowed() {
        this.available = false;
    }

    public void markAsReturned() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + (available ? "yes" : "no") +
                '}';
    }
}
