import java.util.Scanner;

public class CountOfEqualBitPairs {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("n=");
		int n = Integer.parseInt(scanner.next());
		String nToBinary = Integer.toBinaryString(n);
		char[] nToBinaryCharArray = nToBinary.toCharArray();
		
		int countOfEqualBitPairs = 0;
		
		for (int i = 0; i < nToBinaryCharArray.length - 1; i++) {
			if(nToBinaryCharArray[i] == nToBinaryCharArray[i + 1]) {
				countOfEqualBitPairs++;
			}
		}
		
		System.out.printf("Count of equal bit pairs in the binary representation of the number %1$d is: %2$d", n, countOfEqualBitPairs);

	}

}
