import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Triangulization {
    private ImageReader ir;

    public void generatePoints(int numX, int numY) {

    }

    public void generatePoints(int numCluster) {

    }

    public Triangle createSuperTriangle() throws IOException {
        try {
            ir = new ImageReader();
            int width = ir.getWidth();
            int height = ir.getHeight();
            Coordinate a = new Coordinate(0, 0);
            Coordinate b = new Coordinate(2 * width, 0);
            Coordinate c = new Coordinate(0, 2 * height);
            return new Triangle(a, b, c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isInsideTriangle(Triangle triangle, Coordinate coord) {
        double area = triangle.getArea();

    }

    public Set<Triangle> BowyerWatson(HashSet<Coordinate> pointList) throws IOException {
        // Algorithm created using BowyerWatson from wikipedia (wikipedia.org/wiki/Bowyer-Watson-Algorithm
        Set<Triangle> triangulation = new HashSet<Triangle>();
        triangulation.add(createSuperTriangle());
        for (Coordinate coord : pointList) {
            HashSet<Triangle> badTriangles = new HashSet<>();
            for (Triangle triangle : triangulation) {
                if (triangle.isInside(coord)) {
                }
            }
        }
    }
}
