/**
 * This program is able to find all the multiples of 3 or 5 under 1000.
 * 
 * @return Returns the sum of all the multiples of 3 or 5 under 1000.
 * @version 1.0.0
 * @author Dragos Bajanica <bajanica.dragos@gmail.com>
 */
class Main {

    public void main() {
    }

    public static void main(String[] args) {
        int x = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                x += i;
            }
        }
        System.out.println(x);
    }
}