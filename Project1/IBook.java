package Project1;

import java.io.IOException;

public interface IBook {
    void loadData() throws IOException;

    void searchByAuthor(String name);

    void searchByTitle(String title);

    void searchByPublisherName(String name);
}