/**
 * CSE3040 HW2
 * Level013.java
 * Purpose: Calculates area of multiple shapes
 *
 * @version 1.0 Nov. 4. 2019.
 * @author MJ Shin
 */


/**
 * Default interface for implementing Shape
 */
interface Shape {
    /**
     * Get area of this shape.
     * @return Area of the shape.
     */
    double area();
}

/**
 * Class representing rectangle shape.
 */
class Rectangle implements Shape {
    private double width, height;

    /**
     * Constructor
     * @param width Width of this rectangle
     * @param height Height of this rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        // A = W * H
        return this.width * this.height;
    }
}

/**
 * Class implementing square shape
 */
class Square extends Rectangle {
    /**
     * Constructor
     * @param width Width(=height) of this square
     */
    public Square(double width) {
        super(width, width);
    }
}

/**
 * Class implementing circle shape.
 */
class Circle implements Shape {
    private double radius;

    /**
     * Constructor
     * @param radius Radius of this circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        // A = PI * r^2
        return radius * radius * Math.PI;
    }
}

/**
 * Main class
 */
public class Level013 {
    public static void main(String args[]) {
        Shape[] arr = {
                new Circle(5.0),
                new Square(4.0),
                new Rectangle(3.0, 4.0),
                new Square(5.0)
        };
        System.out.println("Total area of the shapes is: " + sumArea(arr));
    }

    /**
     * Method for returning the total of given Shape's area.
     * @param shapeArray List of Shapes
     * @return sum of areas of all Shapes in shapeArray
     */
    static double sumArea(Shape[] shapeArray) {
        double sum = 0;
        for(Shape s: shapeArray) {
            sum += s.area();
        }
        return sum;
    }
}