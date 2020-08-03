public class Triangle {

    private Coordinate A;
    private Coordinate B;
    private Coordinate C;
    private Edge AEdge;
    private Edge BEdge;
    private Edge CEdge;

    public Triangle(Coordinate A, Coordinate B, Coordinate C) {
        this.A = A;
        this.B = B;
        this.C = C;
        AEdge = new Edge(A, B);
        BEdge = new Edge(B, C);
        CEdge = new Edge(C, A);
    }

    /**
     * Calculate area of three triangles (PAB, PBC, PAC) from point P. If the sum of the
     * three triangles' areas matches the target triangle's area, it is inside.
     *
     * @param point, Coordinate for inspection
     * @return boolean, true if the (x,y) Coordinate is a point inside the triangle
     */
    public boolean isInside(Coordinate point) {
        return true;
    }

    /**
     * Find the area of the triangle using A = 1/2(ab*sin(C))
     * Find the area of the triangle using A = sqrt(p(p-a)(p-b)(p-c)) where p = perimeter/2 = a+b+c/2
     * @return float, the area of the triangle
     */
    public double getArea() {
        return getArea(A, B, C); // use field variables
    }

    /**
     * Static method to determine area of a triangle given 3 points
     *
     * @param A, first coord
     * @param B, second coord
     * @param C, third coord
     * @return double, the area of the triangle
     */
    public static double getArea(Coordinate A, Coordinate B, Coordinate C) {
        double a = Coordinate.getDistance(A, B);
        double b = Coordinate.getDistance(B, C);
        double c = Coordinate.getDistance(C, A);

        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p - b)*(p - c));
    }

    /**
     *
     * @param a, edge a
     * @param b, edge b
     * @param c, angle C
     * @return float, the area of the circle
     */
    public double calcArea(float a, float b, float c) {
        // A = 1/2 (ab * sinC)
        return (a*b*Math.sin(c))/2;
    }

    /**
     * Calculate the angle between two edges
     * @param a, edge a
     * @param b, edge b
     * @return float, the angle in radiands
     */
    public static float calcAngle(Edge a, Edge b) {
        return 1;
    }

    public Edge[] getEdges() {
        Edge[] edges = new Edge[3];
        edges[0] = AEdge;
        edges[1] = BEdge;
        edges[2] = CEdge;
        return edges;
    }

    public int[] getXs() {
        int[] xVals = new int[3];
        xVals[0] = A.getX();
        xVals[1] = B.getX();
        xVals[2] = C.getX();
        return xVals;
    }

    public int[] getYs() {
        int[] yVals = new int[3];
        yVals[0] = A.getY();
        yVals[1] = B.getY();
        yVals[2] = C.getY();
        return yVals;
    }
}


