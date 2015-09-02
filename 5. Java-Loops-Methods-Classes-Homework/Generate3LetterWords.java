import java.util.Scanner;

public class Generate3LetterWords {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.print("Enter characters to form 3 letter words:");
        String input = scanner.nextLine().trim().toLowerCase();

        char[] letter = input.toCharArray();

        for (int ch1 = 0; ch1 < letter.length; ch1++) {
            for (int ch2 = 0; ch2 < letter.length; ch2++) {
                for (int ch3 = 0; ch3 < letter.length; ch3++) {
                    System.out.print("" + letter[ch1] + letter[ch2] + letter[ch3] + " ");
                }
            }
        }
    }
}