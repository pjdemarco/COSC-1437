import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookManager {

    private List<Book> bookList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BookManager bookManager = new BookManager();
        bookManager.loadData();
        bookManager.process();
    }

    public void loadData() throws IOException {
        Set<String> bookSet = new HashSet<>();

        List<Book> bookTempList = new ArrayList<>();

        FileReader fr = new FileReader("C:\\Users\\demar\\Desktop\\23aef12e9bf56c618c41-c05e98672b8d52fa0cb94aad80f75eb78342e5d4\\books.csv");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        Book book;

        while (line != null) {
            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            book = new Book(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]);

            bookTempList.add(book);

            line = br.readLine();
        }

        for (Book b : bookTempList) {
            if (bookSet.size() == 0) {
                bookSet.add(b.getTitle());
                bookList.add(b);
            } else {
                if (!bookSet.contains(b.getTitle())) {
                    bookSet.add(b.getTitle());
                    bookList.add(b);
                }
            }
        }
    }

    public void process() {
        System.out.println("Press 1 to sort by Genre. (Must first uncomment lines 41-44 and comment out lines 46-49 in Book.java)");
        System.out.println("Press 2 to sort by Author.(Must first uncomment lines 46-49 and comment out lines 41-44 in Book.java)");
        System.out.println("Press 3 to reverse the book titles.");
        System.out.println("Press 4 to find the number of Books a publisher has.");
        System.out.println("Press 5 to exit.");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice < 1 | choice > 5) {
            System.out.println("Invalid Selection");
            process();
        } else if (choice == 1) {
            sortByGenre();
            process();
        } else if (choice == 2) {
            sortByAuthor();
            process();
        } else if (choice == 3) {
//            System.out.println("Enter the title to reverse: ");
//            String title = sc.nextLine();
            reverseTitle();
            process();
        } else if (choice == 4) {
            System.out.println("Enter the publisher name: ");
            String pub = sc.nextLine();
            publisherBooks(pub);
            process();
        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public void sortByGenre() {
        Collections.sort(bookList);
        System.out.println(bookList);
    }

    public void sortByAuthor() {
        Collections.sort(bookList);
        System.out.println(bookList);
    }

//    public void reverseTitle(String title) {
//        System.out.println("Book Title: " + title + "\n");
//        String[] str = title.trim().split(" ");
//        Stack<String> wordStack = new Stack<>();
//
//        for (String words : str) {
//            if (words.endsWith(".")) {
//                wordStack.push(words.toLowerCase().substring(0, words.length() - 1));
//                break;
//            } else {
//                wordStack.push(words);
//            }
//        }

        public void reverseTitle() {
            for (Book book : bookList) {
                String title = book.getTitle();
                System.out.println("Book Title: " + title + "\n");
                String[] str = title.trim().split(" ");
                Stack<String> wordStack = new Stack<>();

                for (String words : str) {
                    if (words.endsWith(".")) {
                        wordStack.push(words.toLowerCase().substring(0, words.length() - 1));
                        break;
                    } else {
                        wordStack.push(words);
                    }
                }


                StringBuilder sb = new StringBuilder();
                while (!wordStack.isEmpty()) {
                    if (wordStack.size() == 1) {
                        String str2 = wordStack.pop();
                        sb.append(str2.substring(0, 1).toLowerCase() + str2.substring(1)).append(" ");
                    } else {
                        sb.append(wordStack.pop()).append(" ");
                    }
                }
                sb.setLength(sb.length() - 1);
//                sb.append(".");
                String reversed = sb.toString();
                System.out.println("Reversed Title: " + reversed.substring(0, 1).toUpperCase() + reversed.substring(1) + "\n");
            }
        }

    public void publisherBooks(String publisher) {
        int count = 0;
        for (Book book : bookList) {
            if(book.getPublisher().equalsIgnoreCase(publisher)) {
                count++;
            }
        }
        System.out.println(publisher + " has " + count + " books.");
    }
}
