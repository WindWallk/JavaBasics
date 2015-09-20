package org.windwallk.Geometry.Interfaces;

public interface VertexDistanceCalculable {
    double getX();

    double getY();

    double calculateDistance(VertexDistanceCalculable otherVertex);
}
