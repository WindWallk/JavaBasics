import java.util.Scanner;

public class PointsInsideAFigure {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("x=");
		double x = Double.parseDouble(scanner.next());
		
		System.out.print("y=");
		double y = Double.parseDouble(scanner.next());
		
		boolean pointInsideFirstFigure = (x >= 12.5 && x <= 17.5)
										 && (y >= 8.5 && y <= 13.5);
		
		boolean pointInsideSecondFigure = (x >= 12.5 && x <= 22.5)
				  						  && (y >= 6 && y <= 8.5);
		
		boolean pointInsideThirdFigure = (x >= 20 && x <= 22.5)
										 && (y >= 8.5 && y <= 13.5);
		
		if(pointInsideFirstFigure || pointInsideSecondFigure || pointInsideThirdFigure){
			System.out.println("Inside");
		}
		else{
			System.out.println("Outside");
		}
	}

}
