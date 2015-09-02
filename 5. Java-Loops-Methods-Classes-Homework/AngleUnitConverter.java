import java.util.Scanner;

public class AngleUnitConverter {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.print("Number of conversions:");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            double number = Double.parseDouble(inputLine[0]);
            if (number == 0) {
                System.out.printf("%.6f", number);
                System.out.println();
                continue;
            }
            String measure = inputLine[1];
            if (measure.equals("deg")) {
                convertDegreesToRadians(number);
            } else if (measure.equals("rad")) {
                convertRadiansToDegrees(number);
            } else {
                System.out.println("Incorrect measure!");
            }
        }
    }

    private static void convertRadiansToDegrees(double number) {
        double numberInDegrees = Math.toDegrees(number);
        System.out.printf("%.6f deg", numberInDegrees);
        System.out.println();
    }

    private static void convertDegreesToRadians(double number) {
        double numberInRadians = Math.toRadians(number);
        System.out.printf("%.6f rad", numberInRadians);
        System.out.println();
    }
}