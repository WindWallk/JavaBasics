package org.windwallk.Geometry.Shapes.SpaceShapes;

import org.windwallk.Geometry.Vertices.Vertex3D;

public class Cuboid extends SpaceShape {
    private double width;
    private double height;
    private double depth;

    public Cuboid(Vertex3D vertex, double width, double height, double depth) {
        super(vertex);
        this.setWidth(width);
        this.setHeight(height);
        this.setDepth(depth);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public double getArea() {
        double area = 2 *
                (this.getDepth() * this.getWidth() + this.getWidth() * this.getHeight() + this.getHeight() * this.getDepth());
        return area;
    }

    @Override
    public double getVolume() {
        double volume = this.getWidth() * this.getHeight() * this.getDepth();
        return volume;
    }

    @Override
    public String toString() {
        StringBuilder cuboid = new StringBuilder();
        cuboid.append(String.format(
                "Cuboid:%nWidth = %.2f;%nHeight = %.2f;%nDepth = %.2f;%nVolume = %.2f;%nArea = %.2f;%n",
                this.getWidth(), this.getHeight(), this.getDepth(), this.getVolume(), this.getArea()));
        cuboid.append(String.format("Coordinates: %s%n", this.getVertex()));

        return cuboid.toString();
    }
}
