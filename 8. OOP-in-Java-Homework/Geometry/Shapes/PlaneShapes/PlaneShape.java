package org.windwallk.Geometry.Shapes.PlaneShapes;

import org.windwallk.Geometry.Interfaces.AreaMeasurable;
import org.windwallk.Geometry.Interfaces.PerimeterMeasurable;
import org.windwallk.Geometry.Shapes.Shape;
import org.windwallk.Geometry.Vertices.Vertex2D;

import java.util.ArrayList;

public abstract class PlaneShape extends Shape implements AreaMeasurable, PerimeterMeasurable, Comparable<PlaneShape> {
    private ArrayList<Vertex2D> vertices;

    protected PlaneShape() {
        this.vertices = new ArrayList<>();
    }

    public Iterable<Vertex2D> getVertices() {
        return this.vertices;
    }

    protected void addVertices(Vertex2D... vertices) {
        for (Vertex2D vertex : vertices) {
            this.vertices.add(vertex);
        }
    }

    @Override
    public int compareTo(PlaneShape other) {
        if (this.getPerimeter() > other.getPerimeter()) {
            return 1;
        } else if (this.getPerimeter() < other.getPerimeter()) {
            return -1;
        }
        return 0;
    }
}
