package org.windwallk.Geometry.Shapes.PlaneShapes;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.windwallk.Geometry.Vertices.Vertex2D;

public class Triangle extends PlaneShape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Vertex2D pointA, Vertex2D pointB, Vertex2D pointC) throws InvalidArgumentException {
        super();
        super.addVertices(pointA, pointB, pointC);

        this.sideA = pointC.calculateDistance(pointB);
        this.sideB = pointC.calculateDistance(pointA);
        this.sideC = pointA.calculateDistance(pointB);

        this.isValidTriangle(sideA, sideB, sideC);
    }

    private void isValidTriangle(double sideA, double sideB, double sideC) throws InvalidArgumentException {
        boolean isValidA = sideB + sideC > sideA;
        boolean isValidB = sideA + sideC > sideB;
        boolean isValidC = sideA + sideB > sideC;
        boolean isValidTriangle = isValidA && isValidB && isValidC;
        if (!isValidTriangle) {
            String[] message = new String[]{"Those points do not form a triangle!"};
            throw new InvalidArgumentException(message);
        }
    }

    @Override
    public double getArea() {
        double halfPerimeter = this.getPerimeter() / 2;
        double area = Math.sqrt(
                halfPerimeter * (halfPerimeter - this.sideA) * (halfPerimeter - this.sideB) * (halfPerimeter - this.sideC));

        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = this.sideA + this.sideB + this.sideC;
        return perimeter;
    }

    @Override
    public String toString() {
        StringBuilder triangle = new StringBuilder();
        triangle.append(String.format(
                "Triangle:%na = %.2f;%nb = %.2f;%nc = %.2f;%nPerimeter = %.2f;%nArea = %.2f;%n",
                this.sideA, this.sideB, this.sideC, this.getPerimeter(), this.getArea()));
        triangle.append(String.format("Coordinates: %s%n", this.getVertices().toString()));

        return triangle.toString();
    }
}
