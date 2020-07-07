/**
 * CSE3040 HW2
 * Level014.java
 * Purpose: Calculate distance between two points in N-dimensional space, with
 * euclidean distance and manhattan distance as two distance metric.
 *
 * @version 1.0 Nov. 4. 2019.
 * @author MJ Shin
 */

/**
 * Class representing a point in N-D space.
 */
class Point {
    private double[] point;

    /**
     * Constructor
     * @param point Array of double representing point's coordination.
     */
    public Point(double[] point) {
        this.point = point;
    }

    /**
     * Get this point's dimension
     * @return Dimension this point is in.
     */
    public int getDimension() {
        return this.point.length;
    }

    /**
     * Get coordinate of the point at given dimension.
     * @param index Dimension to look for values
     * @return Value at dimension.
     * @throws ArrayIndexOutOfBoundsException
     */
    public double getPositionAt(int index) {
        // Generate RuntimeException when index is out of range.
        if(index < 0 || index >= this.getDimension()) {
            throw new ArrayIndexOutOfBoundsException("Position index is not within the dimension");
        }
        return this.point[index];
    }
}

/**
 * Class to calculate euclidean distance.
 */
class EuclideanDistance {
    /**
     * Calculate euclidean distance between two points.
     * @param p1 First point to measure distance between.
     * @param p2 Second point to measure distance between.
     * @return Euclidean distance in double type. If two points have different
     * dimensions, then the returned value is -1.
     */
    public static double getDist(Point p1, Point p2) {
        int dimension;
        double partSum, distance;
        dimension = p1.getDimension();

        // check for dimensions of two points
        if(dimension != p2.getDimension())
            return -1;

        partSum = 0;
        for(int i=0 ; i<dimension ; i++) {
            // Square the differences of two coordinates, then add them together
            partSum += Math.pow(p1.getPositionAt(i)-p2.getPositionAt(i), 2.0);
        }
        distance = Math.sqrt(partSum);
        return distance;
    }
}

/**
 * Class to calculate manhattan distance.
 */
class ManhattanDistance {
    /**
     * Calculate manhattan distance between two points.
     * @param p1 First point to measure distance between.
     * @param p2 Second point to measure distance between.
     * @return Manhattan distance in double type. If two points have different
     * dimensions, then the returned value is -1.
     */
    public static double getDist(Point p1, Point p2) {
        int dimension;
        double distance = 0;
        dimension = p1.getDimension();

        // check for dimensions of two points
        if(dimension != p2.getDimension())
            return -1;

        for(int i=0 ; i<dimension ; i++) {
            // distance = |p1 - p2|
            distance += Math.abs(p1.getPositionAt(i) - p2.getPositionAt(i));
        }
        return distance;
    }
}

/**
 * Main class
 */
public class Level014 {
    public static void main(String[] args) {
        Point p1 = new Point(new double[]{1.0, 2.0, 3.0});
        Point p2 = new Point(new double[]{4.0, 5.0, 6.0});
        System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
        System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
        Point p3 = new Point(new double[]{1.0, 2.0, 3.0});
        Point p4 = new Point(new double[]{4.0, 5.0});
        System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
        System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
    }
}