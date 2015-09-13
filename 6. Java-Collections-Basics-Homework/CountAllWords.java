import java.util.Scanner;

public class CountAllWords {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[\\W]+");

        System.out.println(words.length);
    }
}
