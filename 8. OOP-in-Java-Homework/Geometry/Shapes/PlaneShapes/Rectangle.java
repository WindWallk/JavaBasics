package org.windwallk.Geometry.Shapes.PlaneShapes;

import org.windwallk.Geometry.Vertices.Vertex2D;

public class Rectangle extends PlaneShape {
    private double width;
    private double height;

    public Rectangle(Vertex2D point, double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        super.addVertices(point);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        double area = this.getWidth() * this.getHeight();
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * (this.getWidth() + this.getHeight());
        return perimeter;
    }

    @Override
    public String toString() {
        StringBuilder rectangle = new StringBuilder();
        rectangle.append(String.format(
                "Rectangle:%nWidth = %.2f;%nHeight = %.2f;%nPerimeter = %.2f;%nArea = %.2f;%n",
                this.getWidth(), this.getHeight(), this.getPerimeter(), this.getArea()));
        rectangle.append(String.format("Coordinates: %s%n", this.getVertices().toString()));

        return rectangle.toString();
    }
}
