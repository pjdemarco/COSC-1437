package Project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookManager implements IBook {
    private List<Publisher> bookList = new ArrayList<>();
    private List<Publisher> authorList = new ArrayList<>();
    private List<Publisher> publisherList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BookManager bookManager = new BookManager();
        bookManager.loadData();
        bookManager.search();
    }

    public void loadData() throws IOException {
        Set<String> pubSet = new HashSet<>();
        Set<String> authSet = new HashSet<>();
        Set<String> bookSet = new HashSet<>();

        List<Publisher> pubTempList = new ArrayList<>();
        List<Author> authTempList = new ArrayList<>();
        List<Book> bookTempList = new ArrayList<>();

        FileReader fileReader = new FileReader("C:\\Users\\demar\\Desktop\\Java\\COSC1437Project1b\\src\\Project1\\data.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        Publisher publisher;
        Book book;
        Author author;

        while (line != null) {
            String[] data = line.split(",");

            publisher = new Publisher(Integer.parseInt(data[0]), data[1], data[2]);
            book = new Book(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]));
            author = new Author(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[6]), data[7], Integer.parseInt(data[8]));

            pubTempList.add(publisher);
            bookTempList.add(book);
            authTempList.add(author);

            line = bufferedReader.readLine();
        }

        for (Publisher p : pubTempList) {
            if (pubSet.size() == 0) {
                pubSet.add(p.getName());
                publisherList.add(p);

            } else {
                if (pubSet.contains(p.getName())) {

                } else {
                    pubSet.add(p.getName());
                    publisherList.add(p);
                }
            }
        }

        for (Author a : authTempList) {
            if (authSet.size() == 0) {
                authSet.add(a.getName());
                authorList.add(a);
            } else {
                if (authSet.contains(a.getName())) {

                } else {
                    authSet.add(a.getName());
                    authorList.add(a);
                }
            }
        }

        for (Book b : bookTempList) {
            if (bookSet.size() == 0) {
                bookSet.add(b.getName());
                bookList.add(b);

            } else {
                if (bookSet.contains(b.getName())) {

                } else {
                    bookSet.add(b.getName());
                    bookList.add(b);
                }
            }
        }
    }

    public void search() {
        System.out.println("Press 1 to search by publisher name.");
        System.out.println("Press 2 to search by book title.");
        System.out.println("Press 3 to search by author name.");
        System.out.println("Press 4 to exit.");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > 4) {
            System.out.println("Invalid selection.");
            search();
        } else if (choice == 1) {
            System.out.println("Enter the name of the publisher.");
            String name = scanner.nextLine();
            searchByPublisherName(name);
        } else if (choice == 2) {
            System.out.println("Enter the title of the book.");
            String title = scanner.nextLine();
            searchByTitle(title);
        } else if (choice == 3) {
            System.out.println("Enter the name of the author.");
            String authorName = scanner.nextLine();
            searchByAuthor(authorName);
        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public void searchByAuthor(String name) {
        for (Publisher author : authorList) {
            String authorName = author.getName();
            if (authorName.equalsIgnoreCase(name)) {
                System.out.println("Found Author:");
                System.out.println(author.display(author));
                System.out.println("Returning to menu...");
                search();
            }
        }
        System.out.println("Author not found.");
        search();
    }

    public void searchByTitle(String title) {
        for (Publisher book : bookList) {
            String bookTitle = book.getName();
            if (bookTitle.equalsIgnoreCase(title)) {
                System.out.println("Found Book:");
                System.out.println(book.display(book));
                System.out.println("Returning to menu...");
                search();
            }
        }
        System.out.println("Book not found.");
        search();
    }

    public void searchByPublisherName(String name) {
        for (Publisher publisher : publisherList) {
            String publisherName = publisher.getName();
            if (publisherName.equalsIgnoreCase(name)) {
                System.out.println("Found Publisher:");
                System.out.println(publisher.display(publisher));
                System.out.println("Returning to menu...");
                search();
            }
        }
        System.out.println("Publisher not found.");
        search();
    }
}