import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class WordCounter {

    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter();
        wordCounter.readFile();
    }

    public static void readFile() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\demar\\IdeaProjects\\COSC1437Project2\\src\\wordCounter.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        Set<String> wordSet = new TreeSet<>();
        while (line != null) {
            String[] words = line.split(" |, |\\. |\\.");
            for (String word : words) {
                wordSet.add(word);
            }
            for(String word : wordSet) {
                System.out.println(word + " ");
            }
            System.out.println(wordSet.size() + " unique words.");
            System.exit(0);
        }
    }
}
