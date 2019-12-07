package app;

// Import necessary packages
import java.util.*;
import java.lang.Math;

/**
 * The right angle triangle uses mostly the same formulas and methods as any
 * triangle, except it has to go trough more validation. It checks if it has a
 * right angle by using Pythagores' formula.
 * 
 * @version 2.0.0
 * New 2.0.0: Major overhaul to the code and seperated it from the main class.
 * @since 1.0.0
 */
class RightTriangle extends Triangle {

    /**
     * Executes Triangle's constructor.
     * 
     * @since 2.0.0
     */
    public RightTriangle() {
        super();
    }

    /**
     * Method that verifies if this is a right triangle by checking for the
     * inequality triangle theorem and then using Pythagores' formula.
     * 
     * @return Returns if it is a right angle triangle by changing the error boolean
     *         to true or false.
     * @since 1.0.0
     */
    @Override
    public void validate() {
        // Keep the validation from triangle
        super.validate();
        // Sort the array containing all the sides
        Arrays.sort(super.side);
        // Check if Pythagores' formula works
        if (Math.round(Math.pow(super.side[0], 2) + Math.pow(super.side[1], 2)) == Math.round(Math.pow(super.side[2], 2))) {
        } else {
            super.setError(true);
            System.out.println("This triangle doesn't have a right angle.");
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
        System.out.println("\nThe perimiter of the right triangle is: " + super.getPerimiter() + " units. \nThe area of the right triangle is: " + super.getArea() + " units squared.");
    }
}