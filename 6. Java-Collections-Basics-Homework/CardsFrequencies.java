import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CardsFrequencies {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split(" ");

        Map<String, Integer> cardsByCount = new LinkedHashMap<>();
        for (String card : cards) {
            String cardValue = card.substring(0, card.length() - 1);
            Integer count = cardsByCount.get(cardValue);
            if (count == null) {
                count = 0;
            }
            cardsByCount.put(cardValue, count + 1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : cardsByCount.entrySet()) {
            double frequency = ((double)stringIntegerEntry.getValue()*100)/cards.length;
            System.out.printf("%s -> %.2f%%", stringIntegerEntry.getKey(), frequency);
            System.out.println();
        }
    }
}
