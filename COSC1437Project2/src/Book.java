public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private String publisher;

    public Book(String title, String author, String genre, int pages, String publisher) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String toString() {
        String str = "Title: " + getTitle() + "\tAuthor: " + getAuthor() + "\tPublisher: " + getPublisher() + "\tGenre: " + getGenre() + "\tPages: " + getPages() + "\n";
        return str;
    }

    @Override
    public int compareTo(Book book) { // Sort by Genre
        return this.getGenre().compareTo(book.getGenre());
    }

//    @Override
//    public int compareTo(Book book) { // Sort by Author
//        return this.getAuthor().compareTo(book.getAuthor());
//    }
}