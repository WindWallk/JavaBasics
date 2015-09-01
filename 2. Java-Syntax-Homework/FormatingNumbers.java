import java.util.Scanner;

public class FormatingNumbers {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("a=");
		int a = Integer.parseInt(scanner.next());
		
		System.out.print("b=");
		float b = Float.parseFloat(scanner.next());
		
		System.out.print("c=");
		float c = Float.parseFloat(scanner.next());
		
		String aToHex = Integer.toHexString(a).toUpperCase();
		int aToBinary = Integer.parseInt(Integer.toBinaryString(a));
		
		System.out.printf("|%1$-10s|%2$010d|%3$10.2f|%4$-10.3f|", aToHex, aToBinary, b, c);
	}

}
