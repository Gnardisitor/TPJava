package app;

/**
 * This class can make any quadrilateral and calculte its perimiter. It can also
 * calculate the area by separating it with the diagonal of the quadrilateral
 * and then calculate the sum of the area of the 2 triangles by using Heron's
 * formula.
 * 
 * @version 2.0.0
 * New 2.0.0: Major overhaul and seperated it from the main class.
 * @since 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Quadrilateral extends Shape {
    // Create the diagonal of the Quadrilateral
    protected double diagonal;

    /**
     * Executes Shape's constructor and sets the length of the diagonal of the quadrilateral.
     * 
     * @return Returns the length of its diagonal.
     * @since 2.0.0
     */
    public Quadrilateral() {
        super(4);
        this.diagonal = Math.sqrt(Math.pow(this.point[0].getPointX() - this.point[2].getPointX(), 2) + Math.pow(this.point[0].getPointY() - this.point[2].getPointY(), 2));
    }

    /**
     * Method that calculates the perimiter of the quadrilateral.
     * 
     * @return Returns the perimiter of the user-made quadrilateral.
     * @since 1.0.0
     */
    public void perimiter() {
        final double kPerimiter = super.side[0] + super.side[1] + super.side[2] + super.side[3];
        super.setPerimiter(kPerimiter);
    }

    /**
     * This method calculates the area of a irregular quadrilateral by seperating it
     * into 2 triangle, then using Heron's formula.
     * 
     * @return Returns the area of an user-made quadrilateral.
     * @since 2.0.0
     */
    public void area() {
        // Area of the first triangle
        final double kHalfPerimiterTriangle1 = (super.side[0] + super.side[1] + this.diagonal) / 2;
        final double kArea1 = Math.sqrt(kHalfPerimiterTriangle1 * (kHalfPerimiterTriangle1 - super.side[0]) * (kHalfPerimiterTriangle1 - super.side[1]) * (kHalfPerimiterTriangle1 - this.diagonal));
        // Area of the second triangle
        final double kHalfPerimiterTriangle2 = (super.side[2] + super.side[3] + this.diagonal) / 2;
        final double kArea2 = Math.sqrt(kHalfPerimiterTriangle2 * (kHalfPerimiterTriangle2 - super.side[2]) * (kHalfPerimiterTriangle2 - super.side[3]) * (kHalfPerimiterTriangle2 - this.diagonal));
        super.setArea(kArea1 + kArea2);
    }

    /** 
     * The quadrilateral has no way to verify it, so this method doesn't do anything.
     * 
     * @since 2.0.0
     */
    public void validate() {}

    /**
     * Method that prints the results of the calculation of the perimiter and area.
     * 
     * @return Returns in the terminal the perimiter and area of the specified
     *         shape.
     * @since 2.0.0
     */
    @Override
    public void printAll() {
        System.out.println("\nThe perimiter of the quadrilateral is: " + super.getPerimiter() + " units. The area of the quadrilateral is: " + super.getArea() + " units squared.");
    }
}