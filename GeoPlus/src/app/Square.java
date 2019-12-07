package app;

/**
 * The square is extremely similar to the rectangle, except that all the sides
 * are equal, so we just have to add a criterion to check if all sides are
 * equal.
 * 
 * @version 2.0.0
 * New 2.0.0: Major overhaul and seperates it from the main class.
 * @since 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Square extends Rectangle {

    /**
     * Executes Rectangle's constructor.
     * 
     * @since 2.0.0
     */
    public Square() {
        super();
    }

    /**
     * Method that validates the same things as the rectangle except it also checks
     * if all sides are equivalent.
     * 
     * @return Returns if it is a regular square by changing the error boolean to
     *         true or false.
     * @since 1.0.0
     */
    @Override
    public void validate() {
        // Set error to false at the start
        super.setError(false);
        // Check if Pythagore's formula works for both triangles
        if (Math.round(Math.pow(super.side[0], 2) + Math.pow(super.side[1], 2)) == Math.round(Math.pow(super.diagonal, 2)) && 
            Math.round(Math.pow(super.side[2], 2) + Math.pow(super.side[3], 2)) == Math.round(Math.pow(super.diagonal, 2))) {
        }else {
            super.setError(true);    
            System.out.println("This square doesn't have right angles.");
        }
        // Check if sides are equal
        if (super.side[0] == super.side[1] && super.side[1] == super.side[2] && super.side[2] == super.side[3] && super.side[3] == super.side[0]) {
        } else {
            super.setError(true);
            System.out.println("This square doesn't have equivalent sides.");
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
        System.out.println("\nThe perimiter of the square is: " + super.getPerimiter() + " units. \nThe area of the square is: " + super.getArea() + " units squared.");
    }
}