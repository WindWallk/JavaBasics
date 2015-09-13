import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSequence {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        int[] inputAsInts = new int[words.length];

        for (int i = 0; i < inputAsInts.length; i++) {
            inputAsInts[i] = Integer.parseInt(words[i]);
        }

        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < inputAsInts.length - 1; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(inputAsInts[i]);

            while ((i < inputAsInts.length - 1) && (inputAsInts[i + 1] > inputAsInts[i])) {
                temp.add(inputAsInts[i + 1]);
                i++;
            }

            System.out.println(temp);
            if (temp.size() > sequence.size()) {
                sequence.clear();
                sequence.addAll(temp);
            }
        }
        System.out.println("Longest: " + sequence);
    }
}
