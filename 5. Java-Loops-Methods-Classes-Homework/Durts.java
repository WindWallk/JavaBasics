import java.util.Scanner;

public class Durts {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int centerX = Integer.parseInt(scanner.next());
        int centerY = Integer.parseInt(scanner.next());
        int r = Integer.parseInt(scanner.next());
        int n = Integer.parseInt(scanner.next());

        double horizontalRectangleMinX = centerX - r;
        double horizontalRectangleMaxX = centerX + r;
        double horizontalRectangleMinY = centerY - (0.5 * r);
        double horizontalRectangleMaxY = centerY + (0.5 * r);

        double verticalRectangleMinX = centerX - (0.5 * r);
        double verticalRectangleMaxX = centerX + (0.5 * r);
        double verticalRectangleMinY = centerY - r;
        double verticalRectangleMaxY = centerY + r;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());

            if (isPointInRectangle(
                    x,
                    y,
                    horizontalRectangleMinX,
                    horizontalRectangleMaxX,
                    horizontalRectangleMinY,
                    horizontalRectangleMaxY)) {
                System.out.println("yes");
            } else if (isPointInRectangle(
                    x,
                    y,
                    verticalRectangleMinX,
                    verticalRectangleMaxX,
                    verticalRectangleMinY,
                    verticalRectangleMaxY)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isPointInRectangle(
            int x,
            int y,
            double minX,
            double maxX,
            double minY,
            double maxY) {
        boolean isInRectangle = ((x >= minX) && (x <= maxX)) && ((y >= minY) && (y <= maxY));

        return isInRectangle;
    }
}
