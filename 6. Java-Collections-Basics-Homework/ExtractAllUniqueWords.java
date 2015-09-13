import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ExtractAllUniqueWords {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[\\W]+");

        Set<String> uniqueWords = new TreeSet<>();

        for (int i = 0; i < words.length; i++) {
            uniqueWords.add(words[i].toLowerCase());
        }

        System.out.println(String.join(" ", uniqueWords));
    }
}
