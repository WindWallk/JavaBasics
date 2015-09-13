import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfNumbers {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
