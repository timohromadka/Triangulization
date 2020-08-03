import java.io.IOException;
import java.util.Set;

public class Image {
    private static Set<Coordinate> pointSet;

    /**
     * Generate a new noise map with designated parameters
     * @param width, the width of the noise map
     * @param height, the height of the noise map
     * @param featureSize, the relative size of the features (smaller featureSize = more grainy image)
     */
    public static void generate(int height, int width, double featureSize, long seed)
            throws IOException {

        OpenSimplexNoise noise = new OpenSimplexNoise(seed);
        BufferedImage image = new BufferedImage(height, width, BufferedImage.TYPE_BYTE_GRAY);
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                double value = noise.eval(x / featureSize, y / featureSize, 0.0);
                int rgb = 0x010101 * (int)((value + 1) * 127.5);
                image.setRGB(y, x, rgb);
            }
        }
        ImageIO.write(image, "png", new File("noise.png"));
    }
}
