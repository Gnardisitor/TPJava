package app;

// Import necessary packages
import java.lang.Math;

/**
 * The rectangle is a quadrilateral, except it's regular, so its easier to
 * calculate its area, but we have to check if the opposite sides are equal and
 * that all angles are 90 degrees by splitting the rectangle into 2 right
 * triangles and then checking with Pythagores' formula.
 * 
 * @version 2.0.0
 * New 2.0.0: Major overhaul and seperated it from the main class.
 * @since 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Rectangle extends Quadrilateral {

    /**
     * Executes Quadrilateral's constructor.
     * 
     * @since 2.0.0
     */
    public Rectangle() {
        super();
    }

    /**
     * Method that calculates the area of the user-made rectangle.
     * 
     * @return Returns the specified regular rectangle's area.
     * @since 1.0.0
     */
    @Override
    public void area() {
        final double kArea = super.side[0] * super.side[1];
        super.setArea(kArea);
    }

    /**
     * Method that validates if opposite sides are equivalent and if we can do
     * Pythagores' formula on both of the 2 right triangles that should compose a
     * rectangle to check if it has 90 degree angles in all the corners.
     * 
     * @return Returns if it is a regular rectangle by changing the error boolean to
     *         true or false.
     * @since 1.0.0
     */
    @Override
    public void validate() {
        super.setError(false);
        // Check if opposite sides are equivalent
        if (super.side[0] == super.side[2] && super.side[1] == super.side[3]) {
        } else {
            super.setError(true);
            System.out.println("This rectangle doesn't have equivalent opposite sides.");
        }
        // Check if Pythagore's formula works for both triangles
        if (Math.round(Math.pow(super.side[0], 2) + Math.pow(super.side[1], 2)) == Math.round(Math.pow(super.diagonal, 2)) && 
            Math.round(Math.pow(super.side[2], 2) + Math.pow(super.side[3], 2)) == Math.round(Math.pow(super.diagonal, 2))) {
        } else {
            super.setError(true);    
            System.out.println("This rectangle doesn't have right angles.");
        }
    }

    /**
     * Method that prints the results of the calculation of the perimiter and area.
     * 
     * @return Returns in the terminal the perimiter and area of the specified
     *         shape.
     * @since 2.0.0
     */
    @Override
    public void printAll() {
        System.out.println("\nThe perimiter of the rectangle is: " + super.getPerimiter() + " units. \nThe area of the rectangle is: " + super.getArea() + " units squared.");
    }
}