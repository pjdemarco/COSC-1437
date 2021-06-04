import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookManager {
    private List<Author> authorList = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BookManager bookManager = new BookManager();
        System.out.println("Book Manager");
        bookManager.readBooks();
        bookManager.search();
    }

    private void readBooks() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Patrick 1\\Desktop\\Java\\Assignment1c\\src\\book.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        Book book;
        readAuthors();

        while (line != null) {
            String[] data = line.split(",");
            String authorName = data[4];
            Author author = searchAuthorListByName(authorName);
            book = new Book(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), author);
            author.addBookToList(book);
            bookList.add(book);
            line = bufferedReader.readLine();
        }
    }

    private void readAuthors() throws IOException {
        Set<String> authorSet = new HashSet<>();
        List<Author> tempList = new ArrayList<>();
        List<Author> aList = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\Patrick 1\\Desktop\\Java\\Assignment1c\\src\\book.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        Author author;

        while (line != null) {
            String[] data = line.split(",");
            author = new Author(Integer.parseInt(data[5]), data[4]);
            tempList.add(author);
            line = bufferedReader.readLine();
        }

        for (Author a : tempList) {
            if (authorSet.size() == 0) {
                authorSet.add(a.getAuthorName());
                authorList.add(a);
            } else {
                if (authorSet.contains(a.getAuthorName())) {

                } else {
                    authorSet.add(a.getAuthorName());
                    authorList.add(a);
                }
            }
        }
    }

    private void search() {
        System.out.println("Press 1 to search by Title.");
        System.out.println("Press 2 to search by Author.");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > 2) {
            System.out.println("Invalid selection.");
            search();
        } else if (choice == 1) {
            System.out.println("Enter the title of the book.");
            String title = scanner.nextLine();
            searchByTitle(title);
        } else {
            System.out.println("Enter the name of the author.");
            String authorName = scanner.nextLine();
            searchByAuthorName(authorName);
        }
    }

    private void searchByAuthorName(String name) {
        for (Author author : authorList) {
            String authorName = author.getAuthorName();
            if (authorName.equalsIgnoreCase(name)) {
                System.out.println("Found Author:");
                for (Book book : author.getBookList()) {
                    System.out.println(book.toString());
                }
                System.out.println("Returning to menu.");
                search();
            }
        }
        System.out.println("Author not found.");
        search();
    }

    private Author searchAuthorListByName(String authorName) {
        for (Author a : authorList) {
            if (a.getAuthorName().equalsIgnoreCase(authorName)) {
                return a;
            }
        }
        return null;
    }

    private void searchByTitle(String title) {
        for (Book book : bookList) {
            String bookTitle = book.getTitle();
            if (bookTitle.equalsIgnoreCase(title)) {
                System.out.println("Found Book:");
                System.out.println(book.toString());
                System.out.println("Returning to menu.");
                search();
            }
        }
        System.out.println("Book not found.");
        search();
    }
}