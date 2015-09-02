import java.util.Scanner;

public class SymmetricNumbersInRange {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Enter range [start, stop]:");
        int start = Integer.parseInt(scanner.next());
        int end = Integer.parseInt(scanner.next());

        if (start < 0 || start > end || end > 999) {
            System.out.println("Incorrect input");
        } else {
            boolean found = false;

            for (int i = start; i <= end; i++) {
                if (i / 10 == 0) {
                    System.out.print(i + " ");
                    found = true;
                } else if (i / 100 == 0) {
                    if (i % 10 == i / 10) {
                        System.out.print(i + " ");
                        found = true;
                    }
                } else if (i % 10 == i / 100) {
                    System.out.print(i + " ");
                    found = true;
                }
            }

            if (!found) {
                System.out.printf("There are no symmetric numbers in the range [%1$d...%2$d].", start, end);
            }
        }
    }
}