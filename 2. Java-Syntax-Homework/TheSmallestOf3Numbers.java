import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheSmallestOf3Numbers {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		ArrayList<Double> numbers = new ArrayList<Double>();
		
		System.out.println("Enter 3 numbers:");
		for(int i = 0; i < 3; i++){
			System.out.printf("Number %d :", i + 1);
			numbers.add(Double.parseDouble(scanner.next()));
		}
		
		double minNumber = Collections.min(numbers);
		
		DecimalFormat format = new DecimalFormat();
		
		System.out.println(format.format(minNumber));
	}
}
