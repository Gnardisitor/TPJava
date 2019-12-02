
// Import ArrayList utility package
import java.util.ArrayList;

/**
 * This program is able to find all the pair numbers in the fibonacci sequence
 * under or equal to 4 000 000 (under 4 000 001).
 * 
 * @return Returns the sum of all the pair numbers in the fibonacci sequece
 *         under 4 000 001.
 * @version 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Main {

    public void main() {
    }

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(0);
        x.add(1);
        int y = 0;
        int z;
        for (int i = 0; (z = x.get(i) + x.get(i+1)) < 4000001; i++) {
            x.add(z);
            if (z % 2 == 0) {
                y += z;
            }
        }
        System.out.println(y);
    }
}