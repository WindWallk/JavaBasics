package org.windwallk.Geometry.Shapes.SpaceShapes;

import org.windwallk.Geometry.Interfaces.AreaMeasurable;
import org.windwallk.Geometry.Interfaces.VolumeMeasurable;
import org.windwallk.Geometry.Shapes.Shape;
import org.windwallk.Geometry.Vertices.Vertex3D;

import java.util.ArrayList;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {
    private Vertex3D vertex;
    private ArrayList<Vertex3D> vertices;

    protected SpaceShape(Vertex3D vertex) {
        this.vertices = new ArrayList<>();
        this.vertices.add(vertex);
        this.setVertex(vertex);
    }

    public Iterable<Vertex3D> getVertices() {
        return this.vertices;
    }

    public Vertex3D getVertex() {
        return vertex;
    }

    public void setVertex(Vertex3D vertex) {
        this.vertex = vertex;
    }
}
