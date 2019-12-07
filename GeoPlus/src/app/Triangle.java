package app;

// Import necessary packages
import java.lang.Math;

/**
 * This is the basic triangle. It doesn't check for right angles, only for the
 * triangle inequality theorem. It can return the area and perimiter of the
 * user-made triangle.
 * 
 * @version 2.0.0 
 * New 2.0.0: Major overhaul of the code and seperated it from the main class.
 * @since 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Triangle extends Shape {

    /**
     * Executes Shape's constructor.
     * 
     * @since 2.0.0
     */
    public Triangle() {
        super(3);
    }

    /**
     * Method that calculates the perimiter of the triangle.
     * 
     * @return Returns the perimiter of the user-made triangle.
     * @since 1.0.0
     */
    public void perimiter() {
        final double kPerimiter = super.side[0] + super.side[1] + super.side[2];
        super.setPerimiter(kPerimiter);
    }

    /**
     * Method that calculates the area of the user-made triangle.
     * 
     * @return Returns the specified triangle's area.
     * @since 1.0.0
     */
    public void area() {
        final double kHalfPerimiter = super.getPerimiter() / 2;
        // Heron's formula
        final double kArea = Math.sqrt(kHalfPerimiter * (kHalfPerimiter - super.side[0]) * (kHalfPerimiter - super.side[1]) * (kHalfPerimiter - super.side[2]));
        super.setArea(kArea);
    }

    /**
     * Method checks if the is a triangle by using the triangle inequality theorem.
     * This theorem checks if the sum 2 sides is bigger than a single side.
     * 
     * @return Returns if this is a triangle by set the variable error to true or
     *         false.
     * @since 2.0.0
     */
    public void validate() {
        super.setError(false);
        if (super.side[0] + super.side[1] > super.side[2] && super.side[1] + super.side[2] > super.side[0] && super.side[2] + super.side[0] > super.side[1]) {
        } else {
            super.setError(true);
            System.out.println("This triangle doesn't obey to the triangle inequality theorem.");
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
        System.out.println("\nThe perimiter of the triangle is: " + super.getPerimiter() + " units. \nThe area of the triangle is: " + super.getArea() + " units squared.");
    }
}