package org.windwallk.Geometry.Vertices;

import org.windwallk.Geometry.Interfaces.VertexDistanceCalculable;

public class Vertex2D implements VertexDistanceCalculable {
    private double x;
    private double y;

    public Vertex2D(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double calculateDistance(VertexDistanceCalculable otherVertex) {
        double otherX = otherVertex.getX();
        double otherY = otherVertex.getY();

        double distance = Math.sqrt((this.x - otherX) * (this.x - otherX) + (this.y - otherY) * (this.y - otherY));
        return distance;
    }

    @Override
    public String toString() {
        return String.format("[x = %s, y = %s]", this.x, this.y);
    }
}