import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MostFrequentWord {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[\\W]+");

        Map<String, Integer> wordsByCount = new TreeMap<>();

        for (String word : words) {
            Integer count = wordsByCount.get(word);
            if (count == null) {
                count = 0;
            }

            wordsByCount.put(word.toLowerCase(), count + 1);
        }

        int maxValue = 0;
        for (Integer integer : wordsByCount.values()) {
            if (integer > maxValue) {
                maxValue = integer;
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : wordsByCount.entrySet()) {
            if (stringIntegerEntry.getValue() == maxValue) {
                System.out.println(stringIntegerEntry.getKey() + " -> " + maxValue + " times");
            }
        }
    }
}
