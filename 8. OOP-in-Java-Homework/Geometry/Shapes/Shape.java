package org.windwallk.Geometry.Shapes;

import org.windwallk.Geometry.Interfaces.VertexDistanceCalculable;

import java.util.ArrayList;

public abstract class Shape {
    private ArrayList<VertexDistanceCalculable> vertices;

    protected Shape() {
        this.vertices = new ArrayList<>();
    }
}
