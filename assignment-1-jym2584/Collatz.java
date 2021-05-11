import java.util.Scanner;

/**
 * Collatz Conjecture series
 * 
 * @author Jin Moon
 */

public class Collatz {
    /**
     * Collatz conjecture series 
     * 
     * @param n gives an input
     * @return string representation of the sequence. Doesn't show anything if the
     *         initial number is just 1.
     */

    public static String sequence(int n) {
        String result = "";

        if (n <= 0) {
            return result;
        } else if (n == 1) {
            result += n;
        } else {
            result += n + " ";
        }

        if (n <= 1) {
        /** Don't do anything, will just return an empty string
         */
        } else {

            while(n != 1) {
                if (n % 2 == 0) {
                    /** If the initial and calculated number is even, divide by 2 */
                    n = n / 2;
                } else {
                    /** Make the initial number even if it's odd */
                    n = (3 * n) + 1;
                }

                /** Appending our numbers in a single string so we can return it! */
                if (n != 1) {
                    result += n + " ";

                } else {
                    /** except for the last one if n is finally 1
                     * 
                     * Not sure how to do this properly since I was getting errors with trying
                     * to convert int to string. Don't think we learned it either
                     */
                    result += n;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /** Prints out all numbers of the Collatz sequence */
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = input.nextInt();

        if (i >= 1) {
            if ( i <= 9 && i >= 0) {
                System.out.println("Printing out sequence of  " + i + ": '" + sequence(i) + "'");
            } else {
                System.out.println("Printing out sequence of " + i + ": '" + sequence(i) + "'");
            }
        }

        input.close();
        
    }
}
