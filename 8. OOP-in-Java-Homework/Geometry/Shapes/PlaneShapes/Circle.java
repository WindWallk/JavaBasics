package org.windwallk.Geometry.Shapes.PlaneShapes;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.windwallk.Geometry.Vertices.Vertex2D;

public class Circle extends PlaneShape {
    private double radius;

    public Circle(Vertex2D center, double radius) throws InvalidArgumentException {
        this.addVertices(center);
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws InvalidArgumentException {
        if (radius < 0) {
            String[] message = new String[]{"Radius cannot be negative."};
            throw new InvalidArgumentException(message);
        }

        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI * this.getRadius() * this.getRadius();
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * Math.PI * this.getRadius();
        return perimeter;
    }

    @Override
    public String toString() {
        StringBuilder circle = new StringBuilder();
        circle.append(String.format(
                "Circle:%nCenter = %s;%nRadius = %.2f;%nCircumference = %.2f;%nArea = %.2f;%n",
                this.getVertices(), this.getRadius(), this.getPerimeter(), this.getArea()));

        return circle.toString();
    }
}
