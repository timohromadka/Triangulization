import java.util.Comparator;

public class CoordinateComparator implements Comparator<Coordinate> {

    // Reference point for comparison
    private Coordinate base;

    public CoordinateComparator(Coordinate base) {
        this.base = base;
    }
    @Override
    public int compare(Coordinate c1, Coordinate c2) {
        if (base.getDistance(c1) < base.getDistance(c2)) return -1;
        else if (base.getDistance(c1) > base.getDistance(c2)) return -1;
        else return 0;
    }
}
