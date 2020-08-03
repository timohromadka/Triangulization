import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Canvas {
    public static final Color BG_COLOR = Color.WHITE;
    public static final Color LINE_COLOR = Color.RED;
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 500;

    public static void generate(int height, int width, List<Triangle> triangles) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        try {
            ImageIO.write(image, "png", new File("image.png"));
        }
        catch (IOException e) {
            System.out.println("Something went wrong with loading the file");
            e.printStackTrace();
        }

        drawTriangles(triangles, image.getGraphics());
    }

    public static void generate(List<Triangle> triangles) {
        generate(DEFAULT_HEIGHT, DEFAULT_WIDTH, triangles);
    }

    public static void drawTriangles(List<Triangle> triangles, Graphics g) {
        for (Triangle triangle : triangles) {
            g.drawPolyline(triangle.getXs(), triangle.getYs(), 3);
        }
    }
}
