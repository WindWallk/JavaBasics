import java.util.Scanner;

public class SortArrayOfStrings {
	private static Scanner scanner;
	
	public static void main(String[] args) {	
		scanner = new Scanner(System.in);
		
		System.out.print("n=");
		int n = scanner.nextInt();
		
		String arrayToSort[] = new String[n];
		
		// Fill the array
		for(int i = 0; i < n; i++){
			arrayToSort[i] = scanner.next();
		}
		
		// Sorting algorithm(bubble sort)
		boolean sorted = false;
		while(sorted == false){
			sorted = true;
			for(int i = 0; i < n - 1; i++){
				int result = arrayToSort[i].compareTo(arrayToSort[i + 1]);
				
				if(result > 0){
					String temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[i + 1];
					arrayToSort[i + 1] = temp;
					sorted = false;
				}
			}
		}
		
		// Print the array
		for(int i = 0; i < n; i++){
			System.out.println(arrayToSort[i]);
		}
	}

}
