import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class utilizes the Bowyer-Watson algorithm
 * https://en.wikipedia.org/wiki/Bowyer%E2%80%93Watson_algorithm
 *
 * Pseudo-code (from wiki):
 * function BowyerWatson (pointList)
 *    // pointList is a set of coordinates defining the points to be triangulated
 *    triangulation := empty triangle mesh data structure
 *    add super-triangle to triangulation // must be large enough to completely contain all the points in pointList
 *    for each point in pointList do // add all the points one at a time to the triangulation
 *       badTriangles := empty set
 *       for each triangle in triangulation do // first find all the triangles that are no longer valid due to the insertion
 *          if point is inside circumcircle of triangle
 *             add triangle to badTriangles
 *       polygon := empty set
 *       for each triangle in badTriangles do // find the boundary of the polygonal hole
 *          for each edge in triangle do
 *             if edge is not shared by any other triangles in badTriangles
 *                add edge to polygon
 *       for each triangle in badTriangles do // remove them from the data structure
 *          remove triangle from triangulation
 *       for each edge in polygon do // re-triangulate the polygonal hole
 *          newTri := form a triangle from edge to point
 *          add newTri to triangulation
 *    for each triangle in triangulation // done inserting points, now clean up
 *       if triangle contains a vertex from original super-triangle
 *          remove triangle from triangulation
 *    return triangulation
 */

public class Polygonize {

    public static void main(String[] args) {
        List<Coordinate> coords = new ArrayList<>();
        Coordinate c1 = new Coordinate(50, 30);
        Coordinate c2 = new Coordinate(20, 30);
        Coordinate c3 = new Coordinate(10, 20);
        Coordinate c4 = new Coordinate(5, 5);
        Coordinate c5 = new Coordinate(100, 20);
        Coordinate c6 = new Coordinate(1, 100);
        Coordinate c7 = new Coordinate(25, 25);
        coords.add(c1);
        coords.add(c2);
        coords.add(c3);
        coords.add(c4);
        coords.add(c5);
        coords.add(c6);
        coords.add(c7);

        Canvas.generate(triangulize(coords));
    }

    /**
     * Runs in O(n^2 log n).
     * 1. (n) coordinate points
     * 2. each coordinate points required all other points to be sorted (n log n) by distance to the point
     *
     * @param coordinates, coordinate list of all points to be triangulized
     * @return
     */
    public static List<Triangle> triangulize(List<Coordinate> coordinates) {
        List<Triangle> triangles = new ArrayList<>();
        List<Coordinate> coords = coordinates.stream()
                .collect(Collectors.toList());

        for (Coordinate c : coordinates) {
            CoordinateComparator comp = new CoordinateComparator(c); // use current coordinate as reference point
            Collections.sort(coords, comp);

            // construct a new triangle of the two closest points (index 0 will be the point itself)
            System.out.println(c + ":" + coords.get(1) + ":" + coords.get(2));
            triangles.add(new Triangle(c, coords.get(1), coords.get(2)));
        }

        return triangles;
    }
}
