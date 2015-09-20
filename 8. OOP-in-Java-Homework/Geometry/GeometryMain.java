package org.windwallk.Geometry;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.windwallk.Geometry.Shapes.PlaneShapes.*;
import org.windwallk.Geometry.Shapes.Shape;
import org.windwallk.Geometry.Shapes.SpaceShapes.*;
import org.windwallk.Geometry.Vertices.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeometryMain {
    public static void main(String[] args) {
        try {
            Vertex2D pointA = new Vertex2D(15, 15);
            Vertex2D pointB = new Vertex2D(23, 30);
            Vertex2D pointC = new Vertex2D(55, 25);
            Triangle triangle = new Triangle(pointA, pointB, pointC);

            Vertex2D rectangleVertex = new Vertex2D(20, 20);
            Rectangle rectangle = new Rectangle(rectangleVertex, 15, 20);

            Vertex2D circleCenter = new Vertex2D(30, 30);
            Circle circle = new Circle(circleCenter, 15);

            Vertex3D baseCenter = new Vertex3D(15, 15, 10);
            SquarePyramid squarePyramid = new SquarePyramid(baseCenter, 10, 20);

            Vertex3D cuboidVertex = new Vertex3D(10, 10, 15);
            Cuboid cuboid = new Cuboid(cuboidVertex, 10, 5, 4);

            Vertex3D sphereCenter = new Vertex3D(5, 5, 10);
            Sphere sphere = new Sphere(sphereCenter, 5);

            SpaceShape[] spaceShapes = new SpaceShape[]{squarePyramid, cuboid, sphere};
            PlaneShape[] planeShapes = new PlaneShape[]{triangle, rectangle, circle};

            ArrayList<Shape> shapes = new ArrayList<Shape>() {
                {
                    addAll(Arrays.asList(planeShapes));
                    addAll(Arrays.asList(spaceShapes));
                }
            };

            shapes.forEach(System.out::println);

            List<SpaceShape> filteredSpaceShapes = shapes.stream()
                    .filter(s -> s instanceof SpaceShape)
                    .map(s -> (SpaceShape) s)
                    .filter(s -> s.getVolume() > 400).collect(Collectors.toList());

            List<PlaneShape> sortedPlaneShapes = shapes.stream()
                    .filter(s -> s instanceof PlaneShape)
                    .map(s -> (PlaneShape) s)
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("Space shapes with over 400 volume");
            for (SpaceShape filteredSpaceShape : filteredSpaceShapes) {
                System.out.println(filteredSpaceShape.toString().trim());
            }

            System.out.println();
            System.out.println("Sorted Plane Shapes");
            for (PlaneShape sortedPlaneShape : sortedPlaneShapes) {
                System.out.println(sortedPlaneShape.toString().trim());
            }
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
