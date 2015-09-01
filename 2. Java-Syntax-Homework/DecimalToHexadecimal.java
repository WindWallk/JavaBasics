import java.util.Scanner;

public class DecimalToHexadecimal {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("Enter number:");
		int decimalNumber = Integer.parseInt(scanner.next());
		
		String convertedDecimalToHex = Integer.toHexString(decimalNumber);
		
		System.out.printf(
				"The decimal number %d's represetnation in hexadecimal is: %s",
				decimalNumber, 
				convertedDecimalToHex.toUpperCase());

	}

}
