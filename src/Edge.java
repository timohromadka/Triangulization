public class Edge {
    private Coordinate start;
    private Coordinate end;

    public Edge(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Pythagorean Theorem
     * @return
     */
    public double getLength() {
        float run = end.getX() - start.getX();
        float rise = end.getY() - start.getY();
        return Math.abs(Math.sqrt((run*run) + (rise*rise)));
    }

    public double getSlope() {
        float run = end.getX() - start.getX();
        float rise = end.getY() - start.getY();
        return rise/run;
    }

    public double getRun() {
        return end.getX() - start.getX();
    }

    public double getRise() {
        return end.getY() - start.getY();
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }
}
