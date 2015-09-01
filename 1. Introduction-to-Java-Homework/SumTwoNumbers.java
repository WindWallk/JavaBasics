import java.util.Scanner;

public class SumTwoNumbers {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("a=");
		int a = scanner.nextInt();
		System.out.print("b=");
		int b = scanner.nextInt();
		
		int sum = a + b;
		System.out.println("The sum of a + b is: "+ sum);
	}
}
