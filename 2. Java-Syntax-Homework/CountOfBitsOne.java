import java.util.Scanner;

public class CountOfBitsOne {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("n=");
		int n = Integer.parseInt(scanner.next());
		String nToBinary = Integer.toBinaryString(n);
		
		int numberOfOnes = 0;
		
		for (int i = 0; i < nToBinary.length(); i++) {
			if(nToBinary.charAt(i) == '1') {
				numberOfOnes++;
			}
		}
		
		System.out.printf("There are %1$d one bits in the binary representation of number %2$d", numberOfOnes, n);

	}

}
