import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    private int width;
    private int height;

    private BufferedImage bi;
    private File imageFile = new File("../image.png");

    public ImageReader() throws IOException {
        try {
            bi = ImageIO.read(imageFile);
            width = bi.getWidth();
            height = bi.getHeight();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param x, the x coordinate
     * @param y, the y coordinate
     * @return Color, the Color object belonging to the pixel
     */
    public Color getColor(int x, int y) {
        int color = bi.getRGB(x, y);

        // use unsigned right shifts to obtain the red, green, and blue color values (RGB), respectively
        int R = (color>>>16) & 0xFF;
        int G = (color>>>8) & 0xFF;
        int B = (color) & 0xFF;

        return new Color(R, G, B, 1.0);
    }

    /**
     *
     * @param x, the x coordinate
     * @param y, the y coordinate
     * @return int, the RGB value of the pixel
     */
    public int getRGB(int x, int y) {
        return bi.getRGB(x, y);
    }

    public int getWidth() {return width;}

    public int getHeight() {return height;}
}
