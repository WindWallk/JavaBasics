import java.util.*;
import java.util.stream.Collectors;

public class LargesSequenceOfEqualStrings {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));

        Comparator<List<String>> orderByDescendingBySize = (o1, o2) -> {
            Integer o2Size = o2.size();
            Integer o1Size = o1.size();
            return o2Size.compareTo(o1Size);
        };

        List<String> result = wordsList
                .stream()
                .collect(Collectors.groupingBy(w -> w))
                .values()
                .stream()
                .sorted(orderByDescendingBySize)
                .findFirst()
                .orElse(null);

        System.out.println(result);
    }
}
