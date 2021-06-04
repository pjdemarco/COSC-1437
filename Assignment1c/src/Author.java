import java.util.ArrayList;
import java.util.List;

public class Author {
    private int authorId;
    private String authorName;
    private List<Book> bookList;

    public Author(int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.bookList = new ArrayList<>();
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void addBookToList(Book book) {
        bookList.add(book);
    }

    public String toString() {
        String str = "Name: " + authorName + "\nBooks: " + bookList;
        return str;
    }
}
