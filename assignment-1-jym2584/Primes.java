/**
 * Function that goes through the first 100 natural numbers to see if they're prime.
 * 
 * @author Jin Moon
 */
import java.util.Scanner;

public class Primes {
        /**
         * Checks whether a number is prime or not
         * @param n, checks if the given number is prime
         * @return true/false if n is a prime number
         *  */  
    public static boolean isPrime(int n) {
        if (n == 2 || n == 3 || n == 5 || n == 7) { 
            return true;

        } else if (n <= 1) {
            return false;
        }

        if ( n % 3 == 0 || n % 2 == 0 || n % 5 == 0 || n % 7 == 0) {
            /** False conditions:
             *  - If the number modulo by 2 or 3 has no remainder
             */
            return false;

        } else {
            for(int i = 4; i <= n/2; i = i + 2){
                /**
                 * Starting from 4 and while the *even only* incremented number of i is less than 
                 * or equal to half of the initial number
                 */
                if (n % i == 0) { // if they are divisible by each other, then it is not a prime number
                    return false;
                }
            } 
        }
        return true; // Return true if the false conditions are not met
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 100;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int i = input.nextInt();

        if (i >= 1) {
            /** If the number is more than 1, let's check it with our condition! */
            if(isPrime(i)) {
                System.out.println("Is " + i + " a prime number? Yes!!");

            }else {
                System.out.println("Is " + i + " a prime number? No.");
            }
        }

        input.close();

    }

}
