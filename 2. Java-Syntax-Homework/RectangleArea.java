import java.util.Scanner;

public class RectangleArea {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("a=");
		int a = Integer.parseInt(scanner.next());
		System.out.print("b=");
		int b = Integer.parseInt(scanner.next());
		
		int area = a * b;

		System.out.println("Thea rea of the rectangle is: " + area);
	}

}
