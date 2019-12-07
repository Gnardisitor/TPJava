package app;

// Import necessary packages
import java.util.Scanner;
import java.lang.Math;

/**
 * Class that defines a basic shapes. It is the base class of all the other
 * shapes.
 * 
 * @version 2.0.0 
 * New 2.0.0: Major overhaul and seperated it from the main class.
 * @since 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
abstract class Shape implements ShapeInterface {
    // Create arrays
    Point point[];
    double side[];

    // All variables
    private double perimiter;
    private double area;
    private int sideCount = 0;
    private boolean error = false;

    /**
     * This constructor is used to set the amount of sides needed and then calculate
     * the length of the sides.
     * 
     * @param amountOfSides This integer is used to ask how many sides should the
     *                      chosen shape have. This will be used for setting the
     *                      arrays for the sides and points.
     * @return Returns the position of the points and the length of all the sides.
     * @since 2.0.0
     */
    public Shape(int amountOfSides) {
        this.sideCount = amountOfSides;

        // Set arrays
        this.point = new Point[this.sideCount];
        this.side = new double[this.sideCount];

        // Set all points and calculate the sides of the shape
        this.setPoints(this.sideCount);
        this.calculateAllSides();
    }

    /**
     * Sets the perimiter of the shape.
     * 
     * @param newPerimiter This double is used to set the private perimiter double.
     * @return Sets the perimiter.
     * @since 2.0.0
     */
    public void setPerimiter(double newPerimiter) {
        this.perimiter = newPerimiter;
    }

    /**
     * Sets the area of the shape.
     * 
     * @param newArea This double is used to set the area.
     * @return Sets the area.
     * @since 2.0.0
     */
    public void setArea(double newArea) {
        this.area = newArea;
    }

    /**
     * Sets error to true or false depending if the validation criteria were passed
     * or not.
     * 
     * @param newError This boolean sets the error to true or false.
     * @return Sets error.
     * @since 2.0.0
     */
    public void setError(boolean newError) {
        this.error = newError;
    }

    /**
     * Returns the perimiter of the specified shape.
     * 
     * @return Returns the perimiter variable.
     * @since 2.0.0
     */
    public double getPerimiter() {
        return this.perimiter;
    }

    /**
     * Returns the area of the specified shape.
     * 
     * @return Returns the area variable.
     * @since 2.0.0
     */
    public double getArea() {
        return this.area;
    }

    /**
     * Returns error of the specified shape.
     * 
     * @return Returns error boolean.
     * @since 2.0.0
     */
    public boolean getError() {
        return this.error;
    }

    /**
     * Method that calculates the length of a side of the specified shape.
     * 
     * @param sideId The side you want to calculate.
     * @param point1 The first point necessary to calculate the length of this side.
     * @param point2 The first point necessary to calculate the length of this side.
     * @return Returns to the array the length of a side.
     * @since 1.0.0
     */
    public void lengthSide(int sideId, int point1, int point2) {
        // Formula for the distance between two points
        this.side[sideId] = Math.sqrt(Math.pow(this.point[point2].getPointX() - this.point[point1].getPointX(), 2)
                + Math.pow(this.point[point2].getPointY() - this.point[point1].getPointY(), 2));
    }

    /**
     * Method that calculates the length of all the sides of the specified shape.
     * 
     * @since 1.0.0
     */
    public void calculateAllSides() {
        for (int i = 0; i < this.sideCount; i++) {
            // If we still aren't at the last side
            if (i + 1 != this.sideCount) {
                this.lengthSide(i, i, i + 1);
                // The last side needs 0 as point2 for the math to work
            } else {
                this.lengthSide(i, i, 0);
            }
        }
    }

    /**
     * Method that prints the results of the calculation of the perimiter and area.
     * 
     * @return Returns in the terminal the perimiter and area of the specified
     *         shape.
     * @since 2.0.0
     */
    public void printAll() {
        System.out.println("The perimiter of the shape is: " + this.getPerimiter() + " units. \nThe area of the shape is: " + this.getArea() + " units squared.");
    }

    /**
     * Method that sets all the necessary points' coordinates of a shape for all the
     * other formulas to work. It's crucial for it to be used.
     * 
     * @param amountOfPoints It needs the amount of points necessary to the shape
     *                       and the x and y coordinates of each seperate point
     * @return Returns all the points' coordinates of the specified shape.
     * @since 1.0.0
     */
    public void setPoints(int amountOfPoints) {
        // Create Necessary variables
        double coordinateX = 0;
        double coordinateY = 0;
        // Create keyboard scanner
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < amountOfPoints; i++) {
            System.out.println("\nPoint " + (i + 1) + ":");
            try {
                System.out.print("X coordinate: ");
                coordinateX = Double.parseDouble(scanner.next());
                System.out.print("Y coordinate: ");
                coordinateY = Double.parseDouble(scanner.next());
            } catch (Exception e) {
                System.out.println("Cannot use letters or symbols for a double.");
                coordinateX = 0;
                coordinateY = 0;
                i--;
                continue;
            }
            this.point[i] = new Point(coordinateX, coordinateY);
        }
        scanner.close();
    }
}