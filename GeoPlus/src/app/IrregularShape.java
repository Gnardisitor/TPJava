package app;

// Import necessary packages
import java.util.ArrayList;

/**
 * This class can make any irregular shape and calculte its perimiter.
 * It can also calculate the area by using the following the following
 * formula: A = 1/2 ∣ ((∑ i=1 n−1) xiyi+1 + xny1) − ((∑ i=1 n−1) xi+1yi − x1yn) ∣.
 * 
 * @version 1.0.0
 * @since 3.1.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
public class IrregularShape extends Shape {
    // Create arrays
    double multipliedX[];
    double multipliedY[];

    // All variable
    private double mulitpiedXResult = 0;
    private double mulitpiedYResult = 0;
    private int sideCount = 0;

    /**
     * Executes Shape's constructor and sets the arrays.
     * 
     * @return Returns the length of the arrays.
     * @since 1.0.0
     */
    public IrregularShape(int amountOfSides) {
        // Set the amount of sides for the specific shape
        super(amountOfSides);
        this.sideCount = amountOfSides;

        // Set the length of the arrays
        this.multipliedX = new double[this.sideCount];
        this.multipliedY = new double[this.sideCount];
    }

    /**
     * Method that calculates the perimiter of the specified irregular shape.
     * 
     * @return Returns the specified irregular shape's perimiter.
     * @since 1.0.0
     */
    @Override
    public void perimiter() {
        // Create perimiter variable
        double perimiter = 0;

        // Add every side of the shape
        for (int i = 0; i < this.sideCount; i++) {
            perimiter += super.side[i];
        }
        super.setPerimiter(perimiter);
    }

    /**
     * This method calculates the area of an irregular shape by multiplying the
     * x coordinate of each vertex by the y coordinate of the next vertex, then
     * repeating the process for the y coordinates. The sum of the second products
     * is then substracted from the first products and divided by two.
     * 
     * @return Returns the area of an user-made shape.
     * @since 1.0.0
     */
    @Override
    public void area() {
        // Create and set arraylist
        final ArrayList<Point> points = new ArrayList<Point>();

        // Set points of arraylist
        for (int i = 0; i < this.sideCount; i++) {
            points.add(super.point[i]);
        }
        points.add(super.point[0]);

        for (int i = 0; i < this.sideCount; i++) {
            // Multiplying the x coordinate of the first point by the y coordinate of the second point.
            this.multipliedX[i] = points.get(i).getPointX() * points.get(i+1).getPointY();
            // Multiplying the x coordinate of the first point by the y coordinate of the second point.
            this.multipliedY[i] = points.get(i).getPointY() * points.get(i+1).getPointX();

            // Add all results of previous calculations
            this.mulitpiedXResult += this.multipliedX[i];
            this.mulitpiedYResult += this.multipliedY[i];
        }
        // Find and set the area of the shape
        super.setArea((this.mulitpiedXResult-this.mulitpiedYResult)/2);
    }

    /** 
     * An irregular shape has no way to be verified, so this method doesn't do anything.
     * 
     * @since 1.0.0
     */
    public void validate() {}
}
