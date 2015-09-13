import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombineListsOfLetters {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        char[] firstListOfLetters = scanner.nextLine().replaceAll(" ", "").toCharArray();
        char[] secondListOfLetters = scanner.nextLine().replaceAll(" ", "").toCharArray();

        List<Character> uniqueCharsOfBothLists = new ArrayList<>();
        List<Character> tempChars = new ArrayList<>();

        for (char firstChar : firstListOfLetters) {
            uniqueCharsOfBothLists.add(firstChar);
            tempChars.add(firstChar);
        }

        for (char secondChar : secondListOfLetters) {
            if (!tempChars.contains(secondChar)) {
                uniqueCharsOfBothLists.add(secondChar);
            }
        }

        for (Character uniqueChar : uniqueCharsOfBothLists) {
            System.out.print(uniqueChar + " ");
        }
    }
}
