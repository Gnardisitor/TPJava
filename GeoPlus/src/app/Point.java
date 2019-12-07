package app;

/**
 * This class is used for each point making up a shape. It only contains the X
 * and Y coordinates.
 * 
 * @version 2.0.0 
 * New 2.0.0: Added constructors and seperated it from the main class.
 * @since 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Point {
    // Private coordinates
    private double x;
    private double y;

    /**
     * Constructor that sets for the first time the x and y coordinates, to be later
     * changed with the setPointX method.
     * 
     * @param newX Double to set the private variable x.
     * @param newY Double to set the private variable y.
     * @return Sets x and y coordinates.
     * @since 2.0.0
     */
    public Point(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * This method sets the point x double.
     * 
     * @param coordinateX This double is used to set the private x double.
     * @return Sets the x coordinate
     * @since 1.0.0
     */
    public void setPointX(double coordinateX) {
        this.x = coordinateX;
    }

    /**
     * This method sets the point y double.
     * 
     * @param coordinateY This double is used to set the private y double.
     * @return Sets the y coordinate.
     * @since 1.0.0
     */
    public void setPointY(double coordinateY) {
        this.y = coordinateY;
    }

    /**
     * Returns the value of x.
     * 
     * @return Returns the value of the x coordinate.
     * @since 1.0.0
     */
    public double getPointX() {
        return this.x;
    }

    /**
     * Returns the value of y.
     * 
     * @return Returns the value of the y coordinate.
     * @since 1.0.0
     */
    public double getPointY() {
        return this.y;
    }
}
