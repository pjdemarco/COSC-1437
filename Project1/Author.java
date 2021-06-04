package Project1;

import java.util.ArrayList;
import java.util.List;

public class Author extends Publisher {
    private int authorId;
    private String name;
    private int dateOfBirth;
    private List<Book> bookList;

    public Author(int id, String name, String location, int authorId, String authorName, int dateOfBirth) {
        super(id, name, location);
        bookList = new ArrayList<>();
        this.authorId = authorId;
        this.name = authorName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        String str = "Name: " + getName() + "\nDate of Birth: " + getDateOfBirth() + "\nPublisher: " + super.getName() + "\nPublisher Location: " + super.getLocation();
        return str;
    }
}