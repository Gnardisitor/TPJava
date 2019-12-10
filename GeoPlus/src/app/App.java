package app;

// Import necessary packages
import java.util.*;

/**
 * This command-based program calculates the perimiter and area of a shape made
 * by the user.
 * 
 * @version 3.0.1 
 * New 3.0.0: Seperated the whole code and redid most of it.
 * New 3.0.1: Put a \n in the Quadrilateral class.
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class App {

    // Create keyboard scanner
    static Scanner scanner = new Scanner(System.in);
    static String command = "";

    /**
     * This is where the commands are inputed and the code is executed.
     * 
     * @param args    The main arguments are put here to be executed.
     * @param command This is the string where the commands are gonna be written
     *                with a scanner and then executed until the person closes the
     *                while true loop with the /exit command.
     * @throws Exception
     * @return Returns the perimiter and the area of the shape that was chosen.
     * @since 1.0.0
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to GeoPlus. \nVersion: 3.0.0 \nType /help to start.");
        boolean exit = false;

        do {
            System.out.println("\nCommand:");
            command = scanner.next();

            // Chooses and executes command
            switch(command) {
                case "/help":
                    System.out.println("To check the possible shapes, use /shapes. \nTo exit the program, use /exit.");
                    break;
                case "/shapes":
                    System.out.println("The possible shapes are: \n/square \n/rectangle \n/quadrilateral \n/triangle \n/rightTriangle");
                    break;
                case "/square":
                    Shape square = new Square();
                    square.validate();
                    if (square.getError() != true) {
                        square.perimiter();
                        square.area();
                        square.printAll();
                    }
                    exit = true;
                    break;
                case "/rectangle":
                    Shape rectangle = new Rectangle();
                    rectangle.validate();
                    if (rectangle.getError() != true) {
                        rectangle.perimiter();
                        rectangle.area();
                        rectangle.printAll();
                    }
                    exit = true;
                    break;
                case "/quadrilateral":
                    Shape quadrilateral = new Quadrilateral();
                    quadrilateral.perimiter();
                    quadrilateral.area();
                    quadrilateral.printAll();
                    exit = true;
                    break;
                case "/triangle":
                    Shape triangle = new Triangle();
                    triangle.validate();
                    if (triangle.getError() != true) {
                        triangle.perimiter();
                        triangle.area();
                        triangle.printAll();
                    }
                    exit = true;
                    break;
                case "/rightTriangle":
                    Shape rightTriangle = new RightTriangle();
                   rightTriangle.validate();
                    if (rightTriangle.getError() != true) {
                        rightTriangle.perimiter();
                        rightTriangle.area();
                        rightTriangle.printAll();
                    }
                    exit = true;
                    break;
                case "/exit":
                    exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.println("Illegal command. Check possible commands with /help.");
            }
        } while(exit != true);
    }
}