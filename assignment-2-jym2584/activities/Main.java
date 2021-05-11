package activities;
package friday;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] objects = new Object[5];

        objects[0] = 5;
        objects[1] = "Hello World";
        objects[2] = new Ship("R2D2", 25, 500);
        objects[3] = new Weapon[3];
        objects[4] = new Year(1000);

        System.out.println(Arrays.toString(objects));
    }
}