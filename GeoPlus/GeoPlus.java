// Import Necessary Packages
import java.util.Map;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

/**
 * This command-based program calculates the perimiter and area of a shape made
 * by the user.
 * 
 * @version 2.1.0
 * New 2.0.0: Changed inheritance on some classes, removing almost 150 unecessary lines of code.
 * New 2.1.0: Removed a few lines and made all coordinates into doubles instead of integers.
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Main {

    // Create Keyboard Scanner
    static Scanner scanner = new Scanner(System.in);

    /**
     * This class is used for each point making up a shape. It only contains the X
     * and Y coordinates.
     * 
     * @since 1.0.0
     */
    public static class Point {
        // Private Coordinates
        private double x;
        private double y;

        /**
         * This method sets the point's x integer.
         * 
         * @param coordinateX This integer is used to set the private x integer.
         * @return Sets the x coordinate
         * @since 1.0.0
         */
        public void setPointX(double coordinateX) {
            this.x = coordinateX;
        }

        /**
         * This method sets the point's y integer.
         * 
         * @param coordinateY This integer is used to set the private y integer.
         * @return Sets the y coordinate.
         * @since 1.0.0
         */
        public void setPointY(double coordinateY) {
            this.y = coordinateY;
        }

        /**
         * @return Returns the value of the x coordinate.
         * @since 1.0.0
         */
        public double getPointX() {
            return this.x;
        }

        /**
         * @return Returns the value of the y coordinate.
         * @since 1.0.0
         */
        public double getPointY() {
            return this.y;
        }
    }

    /**
     * Class that defines a basic shapes. It is the base class of all the other
     * shapes.
     * 
     * @since 1.0.0
     */
    public static abstract class Shape {
        // Create Point Object Array
        protected Point point[] = new Point[4];

        // Area & Perimiter Variables
        protected double perimiter;
        protected double area;

        // Error Variable
        public boolean error = false;

        /**
         * Method that calculates the length of all the sides in the shape.
         * 
         * @since 1.0.0
         */
        public abstract void DistanceLines();

        /**
         * Method that calculates the perimiter of the specified shape.
         * 
         * @since 1.0.0
         */
        public abstract void Perimiter();

        /**
         * Method that calculates the area of the specified shape.
         * 
         * @since 1.0.0
         */
        public abstract void Area();

        /**
         * Method that validates the criteria of the specified shape.
         * 
         * @since 1.0.0
         */
        public abstract void Validate();

        /**
         * Method that sets all the necessary points' coordinates of a shape for all the
         * other formulas to work. It's crucial for it to be used.
         * 
         * @param amount It needs the amount of points necessary to the shape and the x
         *               and y coordinates of each seperate point
         * @return Returns all the points' coordinates of the specified shape.
         * @since 1.0.0
         */
        public void setPoint(int amount) {
            // Create New String
            String coordinate = "";
            label: for (int i = 0; i < amount; ++i) {
                // Create New Object in Array
                point[i] = new Point();
                // Switch Loop for Point Names
                switch (i) {
                case 0:
                    System.out.println("Point A");
                    break;
                case 1:
                    System.out.println("Point B");
                    break;
                case 2:
                    System.out.println("Point C");
                    break;
                case 3:
                    System.out.println("Point D");
                    break;
                }
                // Set X Coordinate of Newly Created Point
                System.out.print("X Coordinate: ");
                coordinate = scanner.next();
                // Check for Error
                try {
                    point[i].setPointX(Double.parseDouble(coordinate));
                } catch (Exception e) {
                    System.out.println("Illegal Coordinate. Cannot use Letters or Symbols for a Double.");
                    break label;
                }
                // Set X if no Errors
                point[i].setPointX(Double.parseDouble(coordinate));
                // Set Y Coordinate of Newly Created Point
                System.out.print("Y Coordinate: ");
                coordinate = scanner.next();
                // Check for Error
                try {
                    point[i].setPointY(Double.parseDouble(coordinate));
                } catch (Exception e) {
                    System.out.println("Illegal Coordinate. Cannot use Letters or Symbols for a Double.");
                    break label;
                }
                // Set Y if no Errors
                point[i].setPointY(Double.parseDouble(coordinate));
            }
        }
    }

    /**
     * This is the basic triangle. It doesn't check for right angles and doesn't
     * need any validation. It can return the area and perimiter of the user-made
     * triangle.
     * 
     * @since 1.0.0
     */
    public static class Triangle extends Shape {
        // Lines Variables
        double AB;
        double BC;
        double AC;

        /**
         * This method calculates the length of each side of the triangle.
         * 
         * @return It gives all the lengths of all the sides of the triangle.
         * @since 1.0.0
         */
        @Override
        public void DistanceLines() {
            AB = (Math.sqrt(Math.pow(point[1].getPointX() - point[0].getPointX(), 2) + Math.pow(point[1].getPointY() - point[0].getPointY(), 2)));
            BC = (Math.sqrt(Math.pow(point[2].getPointX() - point[1].getPointX(), 2) + Math.pow(point[2].getPointY() - point[1].getPointY(), 2)));
            AC = (Math.sqrt(Math.pow(point[0].getPointX() - point[2].getPointX(), 2) + Math.pow(point[0].getPointY() - point[2].getPointY(), 2)));
        }

        /**
         * Method that calculates the perimiter of the triangle.
         * 
         * @return Returns the perimiter of the user-made triangle.
         * @since 1.0.0
         */
        @Override
        public void Perimiter() {
            perimiter = AB + BC + AC;
            System.out.println("The Perimiter of the Triangle is " + perimiter + " units.");
        }

        /**
         * Method that calculates the area of the user-made triangle.
         * 
         * @return Returns the specified triangle's area.
         * @since 1.0.0
         */
        @Override
        public void Area() {
            area = Math.sqrt(perimiter / 2 * (perimiter / 2 - AB) * (perimiter / 2 - BC) * (perimiter / 2 - AC));
            System.out.println("The Area of the Triangle is " + area + " units squared.");
        }
    }

    /**
     * The right angle triangle uses mostly the same formulas and methods as any
     * triangle, except it has to go trough validation to check if it has a right
     * angle by using Pythagores' formula.
     * 
     * @since 1.0.0
     */
    public static class TriangleRectangle extends Triangle {
    
        /**
         * Method that verifies the most important criterion for a right angle triangle:
         * the right angle. It does that by using Pythagores' formula.
         * 
         * @return Returns if it is a right angle triangle by changing the error boolean
         *         to true or false.
         * @since 1.0.0
         */
        @Override
        public void Validate() {
            // Create Array Containing all the Sides
            double[] lines = new double[3];
            lines[0] = AB;
            lines[1] = BC;
            lines[2] = AC;
            // Sort all the Sides by Length in Ascending Order
            Arrays.sort(lines);
            // Check if Pythagores' Formula Works
            if ((float) Math.pow(lines[0], 2) + Math.pow(lines[1], 2) == (float) Math.pow(lines[2], 2)) {
                super.error = false;
            } else {
                super.error = true;
                System.out.println("Illegal Coordinates. There are no Right Angles in this Triangle.");
            }
        }
    }

    /**
     * This class can contain any quadrilateral, so it doesn't have the capacity to
     * calculate the area of an irregular quadrilateral. It also doesn't verify
     * anything because of this shape's irregularity.
     * 
     * @since 1.0.0
     */
    public static class Quadrilateral extends Shape {
        // Lines variables
        double AB;
        double BC;
        double CD;
        double AD;

        /**
         * This method calculates the length of each side of the quadrilateral.
         * 
         * @return It gives all the lengths of all four sides of the quadrilateral.
         * @since 1.0.0
         */
        @Override
        public void DistanceLines() {
            AB = (Math.sqrt(Math.pow(point[1].getPointX() - point[0].getPointX(), 2) + Math.pow(point[1].getPointY() - point[0].getPointY(), 2)));
            BC = (Math.sqrt(Math.pow(point[2].getPointX() - point[1].getPointX(), 2) + Math.pow(point[2].getPointY() - point[1].getPointY(), 2)));
            CD = (Math.sqrt(Math.pow(point[3].getPointX() - point[2].getPointX(), 2) + Math.pow(point[3].getPointY() - point[2].getPointY(), 2)));
            AD = (Math.sqrt(Math.pow(point[0].getPointX() - point[3].getPointX(), 2) + Math.pow(point[0].getPointY() - point[3].getPointY(), 2)));
        }

        /**
         * Method that calculates the perimiter of the quadrilateral.
         * 
         * @return Returns the perimiter of the user-made quadrilateral.
         * @since 1.0.0
         */
        @Override
        public void Perimiter() {
            super.perimiter = AB + BC + CD + AD;
            System.out.println("The Perimiter of the Quadrilateral is " + super.perimiter + " units.");
        }
    }

    /**
     * The rectangle is a quadrilateral, except it's regular, so we can also easily
     * calculate its area, but we also have to validate for at least one of its
     * criterion: having opposite sides be equivalent.
     * 
     * @since 1.0.0
     */
    public static class Rectangle extends Quadrilateral {

        /**
         * Method that calculates the area of the user-made rectangle.
         * 
         * @return Returns the specified regular rectangle's area.
         * @since 1.0.0
         */
        @Override
        public void Area() {
            super.area = AB * BC;
            System.out.println("The Area of the Rectangle is " + super.area + " units squared.");
        }

        /**
         * Method that validates the easiest and most important criterion of the
         * rectangle: that opposite sides are equal.
         * 
         * @return Returns if it is a regular rectangle by changing the error boolean to
         *         true or false.
         * @since 1.0.0
         */
        @Override
        public void Validate() {
            // Check if Opposite Sides are Equal
            if (AB == CD && BC == AD) {
                super.error = false;
            } else {
                super.error = true;
                System.out.println("Illegal Coordinates. This is not a Rectangle.");
            }
        }
    }

    /**
     * The square is extremely similar to the rectangle and quadrilateral, except
     * that the criterion to validate is that all sides are equal.
     * 
     * @since 1.0.0
     */
    public static class Square extends Rectangle {
        
        /**
         * Method that validates the easiest and most important criterion of the
         * rectangle: that all sides are equivalent.
         * 
         * @return Returns if it is a regular square by changing the error boolean to
         *         true or false.
         * @since 1.0.0
         */
        @Override
        public void Validate() {
            // Check if all Sides are Equal
            if (AB == BC && BC == CD && CD == AD) {
                super.error = false;
            } else {
                super.error = true;
                System.out.println("Illegal Coordinates. Not all the Sides of the Square are Equal.");
            }
        }
    }

    /**
     * This is the main loops with the main arguments of the program. It is here
     * that the user uses the created command-based GUI to interact with the code
     * and make shapes and get their area and perimiter.
     * 
     * @param args This main loops contains the mains argument. The user uses a
     *             scanner to input his command and it'll be executed.
     * @return Returns wanted command's function.
     * @since 1.0.0
     */
    public static void main(String[] args) {
        // Create all the Objects
        Square square = new Square();
        Triangle triangle = new Triangle();
        TriangleRectangle triangleRectangle = new TriangleRectangle();
        Quadrilateral quadrilateral = new Quadrilateral();
        Rectangle rectangle = new Rectangle();

        // Print Start Message
        System.out.println("Welcome to GeoPlus.");
        System.out.println("Version: 1.0.0");
        System.out.println("Type /help to Start.");
        System.out.println("");

        // Main Loop for Commands
        label: while (true) {
            System.out.println("");
            String command = "";
            command = scanner.next();
            System.out.println("");

            // Each Possible Command
            switch (command) {
            case "/quadrilateral":
                // Set the Shape's Points
                quadrilateral.setPoint(4);
                // Check for any Null Coordinates
                for (int i = 0; i < 4; ++i) {
                    if (quadrilateral.point[i] == null) {
                        System.out.println("Illegal Coordinates. Necessary Points have not been set. Try Again.");
                        break;
                    } else if (i == 3) {
                        quadrilateral.DistanceLines();
                        quadrilateral.Perimiter();
                    }
                }
                break;
            case "/rectangle":
                // Set the Shape's Points
                rectangle.setPoint(4);
                // Check for any Null Coordinates
                for (int i = 0; i < 4; ++i) {
                    if (rectangle.point[i] == null) {
                        System.out.println("Illegal Coordinates. Necessary Points have not been set. Try Again.");
                        break;
                    } else if (i == 3) {
                        rectangle.DistanceLines();
                        rectangle.Validate();
                        // Check for Failed Criterion
                        if (rectangle.error != true) {
                            rectangle.Perimiter();
                            rectangle.Area();
                        }
                    }
                }
                break;
            case "/square":
                // Set the Shape's Points
                square.setPoint(4);
                // Check for any Null Coordinates
                for (int i = 0; i < 4; ++i) {
                    if (square.point[i] == null) {
                        System.out.println("Illegal Coordinates. Necessary Points have not been set. Try Again.");
                        break;
                    } else if (i == 3) {
                        square.DistanceLines();
                        square.Validate();
                        // Check for Failed Criterion
                        if (square.error != true) {
                            square.Perimiter();
                            square.Area();
                        }
                    }
                }
                break;
            case "/triangle":
                // Set the Shape's Points
                triangle.setPoint(3);
                // Check for any Null Coordinates
                for (int i = 0; i < 3; ++i) {
                    if (triangle.point[i] == null) {
                        System.out.println("Illegal Coordinates. Necessary Points have not been set. Try Again.");
                        break;
                    } else if (i == 2) {
                        triangle.DistanceLines();
                        triangle.Perimiter();
                        triangle.Area();
                    }
                }
                break;
            case "/triangleRectangle":
                // Set the Shape's Points
                triangleRectangle.setPoint(3);
                // Check for any Null Coordinates
                for (int i = 0; i < 3; ++i) {
                    if (triangleRectangle.point[i] == null) {
                        System.out.println("Illegal Coordinates. Necessary Points have not been set. Try Again.");
                        break;
                    } else if (i == 2) {
                        triangleRectangle.DistanceLines();
                        triangleRectangle.Validate();
                        // Check for Failed Criterion
                        if (triangleRectangle.error != true) {
                            triangleRectangle.Perimiter();
                            triangleRectangle.Area();
                        }
                    }
                }
                break;
            case "/help":
                // Show Possible Commands
                System.out.println("Here are the Possible Commands:");
                System.out.println("/triangle");
                System.out.println("/triangleRectangle");
                System.out.println("/quadrilateral");
                System.out.println("/rectangle");
                System.out.println("/square");
                System.out.println("/help");
                System.out.println("/exit");
                break;
            case "/exit":
                // Close Keyboard Scanner and Exit While Loop
                scanner.close();
                break label;
            default:
                // Give Error Message
                System.out.println("Illegal Command. Try Again");
            }
        }
    }
}