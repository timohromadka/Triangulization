import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Pythagorean Theorem
     * @param coord
     * @return
     */
    public double getDistance(Coordinate coord) {
        float run = coord.getX() - x;
        float rise = coord.getY() - y;
        return Math.abs(Math.sqrt((run*run) + (rise*rise)));
    }

    /**
     *
     * @param c1, first coord
     * @param c2, second coord
     * @return double, distance between two points
     */
    public static double getDistance(Coordinate c1, Coordinate c2) {
        float run = c2.getX() - c1.getX();
        float rise = c2.getY() - c1.getY();
        return Math.abs(Math.sqrt((run*run) + (rise*rise)));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate coord = (Coordinate) o;
        return (coord.getX() == x) && (coord.getY() == y);
    }

    @Override
    public int hashcode() {
        return Objects.hash(x, y);
    }
}
