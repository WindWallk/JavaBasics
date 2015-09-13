import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<=\\s|^)([a-z0-9]+(?:[_.-][a-z0-9]+)*@[a-z]+\\-?[a-z]+(?:\\.[a-z]+)+)\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
