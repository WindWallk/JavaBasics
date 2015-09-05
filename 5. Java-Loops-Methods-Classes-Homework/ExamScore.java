import java.util.Scanner;
import java.util.TreeMap;

public class ExamScore {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();

        TreeMap<Integer, TreeMap<String, Double>> container = new TreeMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("\\s*\\|\\s*");
            if (input.length < 4) {
                break;
            }

            String name = input[1];
            int score = Integer.parseInt(input[2]);
            double grade = Double.parseDouble(input[3]);
            if (!container.containsKey(score)) {
                container.put(score, new TreeMap<>());
            }
            container.get(score).put(name, grade);
        }

        for (Integer score : container.keySet()) {
            System.out.print(score + " -> ");
            System.out.print(container.get(score).keySet() + "; ");

            double gradesSum = 0;

            for (double grade : container.get(score).values()) {
                gradesSum += grade;
            }

            double averageGrade = gradesSum / container.get(score).values().size();
            System.out.println(String.format("avg=%.2f", averageGrade));
        }
    }
}
