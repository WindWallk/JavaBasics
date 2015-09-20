package org.windwallk.Geometry.Vertices;

import org.windwallk.Geometry.Interfaces.VertexDistanceCalculable;

public class Vertex3D extends Vertex2D {
    private double z;

    public Vertex3D(double x, double y, double z) {
        super(x, y);
        this.setZ(z);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double calculateDistance(VertexDistanceCalculable otherVertex) {
        Vertex3D other = (Vertex3D) otherVertex;
        double otherX = other.getX();
        double otherY = other.getY();
        double otherZ = other.getZ();

        double distance = Math.sqrt((this.getX() - otherX) * (this.getX() - otherX) + (this.getY() - otherY) * (this.getY() - otherY) +
                (this.getZ() - otherZ) * (this.getZ() - otherZ));

        return distance;
    }
}
