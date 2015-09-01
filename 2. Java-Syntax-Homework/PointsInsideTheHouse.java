import java.util.Scanner;

public class PointsInsideTheHouse {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.print("x=");
		double x = Double.parseDouble(scanner.next());
		
		System.out.print("y=");
		double y = Double.parseDouble(scanner.next());
		
		boolean pointInsideSquare = (x >= 12.5 && x <= 17.5)
									&& (y >= 8.5 && y <= 13.5);
		
		boolean pointInsideRectangle = (x >= 20 && x <= 22.5)
									   && (y >= 8.5 && y <= 13.5);

		boolean pointInsideTriangle = isInsideTriangle(x, y, 12.5, 8.5, 22.5, 8.5, 17.5, 3.5);
		
		if (pointInsideSquare|| pointInsideRectangle || pointInsideTriangle) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}

	private static boolean isInsideTriangle(double x, double y, double aX, double aY, double bX, double bY, double cX, double cY) {
        double ABC = Math.abs(aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY));
        double ABP = Math.abs(aX * (bY - y) + bX * (y - aY) + x * (aY - bY));
        double APC = Math.abs(aX * (y - cY) + x * (cY - aY) + cX * (aY - y));
        double PBC = Math.abs(x * (bY - cY) + bX * (cY - y) + cX * (y - bY));
 
        boolean isInTriangle = ABP + APC + PBC == ABC;
        return isInTriangle;
	}
}
