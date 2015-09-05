import java.util.HashSet;
import java.util.Scanner;

public class CognateWords {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        line = line.replaceAll("[^a-zA-Z'\\s]", " ");
        String[] words = line.split("\\s+");

        HashSet<String> cognateWords = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i != j) {
                        String cognateWord = "" + words[i] + words[j];
                        if (word.equals(cognateWord)) {
                            cognateWords.add(words[i] + "|" + words[j] + "=" + word);
                        }
                    }
                }
            }
        }

        if (cognateWords.isEmpty()) {
            System.out.println("No");
        } else {
            for (String cognateWord : cognateWords) {
                System.out.println(cognateWord);
            }
        }
    }
}
