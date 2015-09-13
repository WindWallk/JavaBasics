import java.util.Scanner;

public class CountSpecifiedWords {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[\\W]+");
        String word = scanner.nextLine();
        int countOfWord = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().equals(word.toLowerCase())) {
                countOfWord++;
            }
        }

        System.out.println(countOfWord);
    }
}
