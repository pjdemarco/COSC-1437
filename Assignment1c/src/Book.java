public class Book {
    private int bookId;
    private String title;
    private String genre;
    private int pages;
    private Author author;

    public Book(int bookId, String title, String genre, int pages, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.pages = pages;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String toString() {
        String str = "ID: " + bookId + " - Title: " + title + " - Genre: " + genre + " - Pages: " + pages;
        return str;
    }
}
