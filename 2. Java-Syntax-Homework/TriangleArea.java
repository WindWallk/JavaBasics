import java.util.Scanner;

public class TriangleArea {
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.println("a:");
		int aX = Integer.parseInt(scanner.next());
        int aY = Integer.parseInt(scanner.next());
        
        System.out.println("b:");
        int bX = Integer.parseInt(scanner.next());
        int bY = Integer.parseInt(scanner.next());
        
        System.out.println("c:");
        int cX = Integer.parseInt(scanner.next());
        int cY = Integer.parseInt(scanner.next());
        
        int triangleArea = Math.abs((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2);
        
        if (triangleArea != 0) {
            System.out.printf("The area of the triangle is: %d", triangleArea);
        }
        else {
            System.out.println("These points do not form a triangle!");
            System.out.println("0");
        }
	}
}
