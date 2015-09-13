import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String words = scanner.nextLine();
        String substring = scanner.nextLine();

        Pattern pattern = Pattern.compile(substring, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(words.toLowerCase());

        int countSubstringOccurrences = 0;
        int start = 0;

        while (matcher.find(start)) {
            countSubstringOccurrences++;
            start = matcher.start() + 1;
        }
        System.out.println(countSubstringOccurrences);
    }
}
