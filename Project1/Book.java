package Project1;

import java.util.List;

public class Book extends Publisher {
    private int bookId;
    private String title;
    private int pubYear;
    private List<Author> authorList;

    public Book(int id, String name, String location, int bookId, String title, int pubYear) {
        super(id, name, location);
        this.bookId = bookId;
        this.title = title;
        this.pubYear = pubYear;
    }

    @Override
    public String getName() {
        return title;
    }

    public int getPubYear() {
        return pubYear;
    }

    public String toString() {
        String str = "Title: " + getName() + "\nPublisher: " + super.getName() + "\nPublication Year: " + getPubYear();
        return str;
    }
}