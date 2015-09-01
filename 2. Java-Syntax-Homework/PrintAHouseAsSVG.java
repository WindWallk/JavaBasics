import java.util.Scanner;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.FileWriter;
import java.io.IOException;
 
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;
public class PrintAHouseAsSVG {

	private static Scanner scanner;
	private static int pictureX = 250;
    private static int pictureY = 200;
	
	public static void main(String[] args) {
		DOMImplementation domImplementation = 
				GenericDOMImplementation.getDOMImplementation();
		String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImplementation.createDocument(svgNS, "svg", null); 
        SVGGraphics2D generator = new SVGGraphics2D(document);
        
        Dimension size = new Dimension(1000, 1000);
        generator.setSVGCanvasSize(size);
        paint(generator);
        try {
			generator.stream(new FileWriter("house.html"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void paint(Graphics2D g2d) {
		scanner = new Scanner(System.in);
		
		System.out.print("Please enter the number of dots you want to visualize:");
		int numberOfDots = Integer.parseInt(scanner.next());
		
		drawBackground(g2d);
        drawFigures(g2d);
        
        for(int i = 0; i < numberOfDots; i++) {
        	double currentPointX = Double.parseDouble(scanner.next());
        	double currentPointY = Double.parseDouble(scanner.next());
        	
        	boolean isInsideHouse = isInsideHouse(currentPointX, currentPointY);
        	drawPoint(g2d, isInsideHouse, currentPointX, currentPointY);
        }
	}

	private static void drawFigures(Graphics2D g2d) {
	    Graphics2D graphics2d = (Graphics2D) g2d;
	   
	    Color purple = new Color(0.5f, 0.5f, 0.5f,0.5f);
	    Color blue = new Color(0, 51, 120);
	   
	    int[] x = new int[]{pictureX + 125, pictureX + 5 * 125, pictureX + 3 * 125};
	    int[] y = new int[]{pictureY + 2 * 125, pictureY + 2 * 125, pictureY};
	    Polygon poligon = new Polygon(x, y, 3);
	   
	    graphics2d.setStroke(new BasicStroke(3));
	    graphics2d.setColor(purple);
	    graphics2d.fillRect(pictureX + 125, pictureY + 2 * 125, 2 * 125, 2 * 125);
	    graphics2d.fillRect(pictureX + 4 * 125, pictureY + 2 * 125, 125, 2 * 125);
	    graphics2d.fillPolygon(poligon);
	   
	    graphics2d.setPaint(blue);
	    graphics2d.drawRect(pictureX + 125, pictureY + 2 * 125, 2 * 125, 2 * 125);               
	    graphics2d.drawRect(pictureX + 4 * 125, pictureY + 2 * 125, 125, 2 * 125);
	    graphics2d.drawPolygon(poligon);
	}

	private static void drawBackground(Graphics2D g2d) {
	    Graphics2D graphics2d = (Graphics2D) g2d;                
	   
	    float dash[] = {1.5f};
	    BasicStroke dashed = new BasicStroke(
	    		1.0f,
	    		BasicStroke.CAP_BUTT,
	    		BasicStroke.JOIN_MITER,
	    		1.5f,
	    		dash,
	    		1.5f);
	    graphics2d.setStroke(dashed);
	    Font font = new Font("Axis", Font.PLAIN, 30);
	    graphics2d.setFont(font);             
	   
	    float x = pictureX;
	    float y = pictureY - 50;
	    float axisX = 10f;
	    float axisY = 3.5f;
	   
	    for (int i = 0; i < 6; i++) {
	            graphics2d.drawString(Float.toString(axisX).replaceAll("\\.?0*$", ""), x - 28, y - 25);
	            graphics2d.draw(new Line2D.Float(x, y, x, y + 5 * 125 + 100));
	            x += 125;
	            axisX += 2.5f;
	    }
	   
	    x = pictureX - 30 ;
	    y = pictureY;
	   
	    for (int i = 0; i < 6; i++) {
	            graphics2d.drawString(Float.toString(axisY).replaceAll("\\.?0*$", ""), x - 75, y + 9);
	            graphics2d.draw(new Line2D.Float(x, y, x + 5 * 125 + 60, y));
	            y += 125;
	            axisY += 2.5f;
	    }                              
	}
	
	private static boolean isInsideHouse(double currentPointX, double currentPointY) {
		boolean pointInsideSquare = (currentPointX >= 12.5 && currentPointX <= 17.5)
									&& (currentPointY >= 8.5 && currentPointY <= 13.5);

		boolean pointInsideRectangle = (currentPointX >= 20 && currentPointX <= 22.5)
				   					   && (currentPointY >= 8.5 && currentPointY <= 13.5);

		boolean pointInsideTriangle = isInsideTriangle(currentPointX, currentPointY, 12.5, 8.5, 22.5, 8.5, 17.5, 3.5);
		
		boolean isInsideHouse = pointInsideSquare || pointInsideRectangle || pointInsideTriangle;
		return isInsideHouse;
	}
	
	private static boolean isInsideTriangle(double x, double y, double aX, double aY, double bX, double bY, double cX, double cY) {
        double ABC = Math.abs(aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY));
        double ABP = Math.abs(aX * (bY - y) + bX * (y - aY) + x * (aY - bY));
        double APC = Math.abs(aX * (y - cY) + x * (cY - aY) + cX * (aY - y));
        double PBC = Math.abs(x * (bY - cY) + bX * (cY - y) + cX * (y - bY));
 
        boolean isInTriangle = ABP + APC + PBC == ABC;
        return isInTriangle;
	}

	private static void drawPoint(Graphics2D g2d, boolean isInsideHouse, double currentPointX, double currentPointY) {
	    Graphics2D graphics2d = (Graphics2D) g2d;
	   
	    int x = (int)(pictureX + (currentPointX - 10) * 125 / 2.5);
	    int y = (int)(pictureY + (currentPointY - 3.5) * 125 / 2.5);
	   
	    Color purple = new Color(0.5f, 0.5f, 0.5f,0.5f);
	    graphics2d.setStroke(new BasicStroke(0.5f));
	    graphics2d.setColor(Color.black);
	    graphics2d.drawOval(x - 7, y - 7, 14, 14);         
	    if (!isInsideHouse) {
	            graphics2d.setColor(purple);
	    }
	    graphics2d.fillOval(x-7, y-7, 14, 14);         
	}

}