package org.windwallk.Geometry.Shapes.SpaceShapes;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.windwallk.Geometry.Vertices.Vertex3D;

public class Sphere extends SpaceShape {
    private double radius;

    public Sphere(Vertex3D center, double radius) throws InvalidArgumentException {
        super(center);
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
        double area = 4 * Math.PI * this.getRadius() * this.getRadius();
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (double) 4 / 3 * Math.PI * this.getRadius() * this.getRadius() * this.getRadius();
        return volume;
    }

    @Override
    public String toString() {
        StringBuilder sphere = new StringBuilder();
        sphere.append(String.format(
                "Sphere:%nCenter = %s;%nRadius = %.2f;%nVolume = %.2f;%nArea = %.2f;%n",
                super.getVertex(), this.getRadius(), this.getVolume(), this.getArea()));

        return sphere.toString();
    }
}
