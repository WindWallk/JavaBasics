package org.windwallk.Geometry.Shapes.SpaceShapes;

import org.windwallk.Geometry.Vertices.Vertex3D;

public class SquarePyramid extends SpaceShape {
    private double baseWidth;
    private double height;

    public SquarePyramid(Vertex3D baseCenter, double baseWidth, double height) {
        super(baseCenter);
        this.setBaseWidth(baseWidth);
        this.setHeight(height);
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        double surfaceArea = this.getBaseWidth() * this.getBaseWidth() + 2 * this.getBaseWidth()
                * Math.sqrt((this.getBaseWidth() * getBaseWidth()) / 4 + this.getHeight() * this.getHeight());

        return surfaceArea;
    }

    @Override
    public double getVolume() {
        double volume = (this.getBaseWidth() * this.getBaseWidth()) * this.getHeight() / 3;
        return volume;
    }

    @Override
    public String toString() {
        StringBuilder squarePyramid = new StringBuilder();
        squarePyramid.append(String.format(
                "Square Pyramid:%nBase Center = %s;%nBase Width = %.2f;%nHeight = %.2f;%nVolume = %.2f;%nArea = %.2f;%n",
                super.getVertex().toString(), this.getBaseWidth(), this.getHeight(), this.getVolume(), this.getArea()));

        return squarePyramid.toString();
    }
}
