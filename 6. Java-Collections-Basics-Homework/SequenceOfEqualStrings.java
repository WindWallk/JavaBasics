import java.util.Scanner;

public class SequenceOfEqualStrings {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.print(words[i]);
            if (words[i].equals(words[i + 1])) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        System.out.println(words[words.length - 1]);
    }
}
