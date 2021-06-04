package Project1;

import java.util.List;

public class Publisher {
    private int id;
    private String name;
    private String location;
    private List<Book> bookList;

    public Publisher(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        String str = "Name: " + getName() + "\nLocation: " + getLocation();
        return str;
    }

    public String display(Publisher publisher) {
        return toString();
    }
}