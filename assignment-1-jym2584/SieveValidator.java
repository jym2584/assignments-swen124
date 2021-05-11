import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Sieve Validation
 * Creates an array based on the filename and then repairs the array if
 * the repairSieve is called.
 * 
 * @author Jin Moon
 */

public class SieveValidator {
    /**
     *  Creates an array based on a given file
     * @param filename takes in a filename
     * @return returns an array of the Sieve
     * @throws IOException prints that the file is invalid
     */
    public static int[] readSieve(String filename) throws IOException {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int size = Integer.parseInt(line);
            int[] sieve = new int[size];
            String sievenumbers = "";
            int count = 0;

            line = br.readLine(); // Parsing through the next line after we get our size

            while (line != null) {
                sievenumbers += line; // appends our numbers to the string
                line = br.readLine();
            }

            for (int i = 0; i < size; i++) { // iterates through the string and converts them into integers
                char a = sievenumbers.charAt(i);
                sieve[i] = Character.getNumericValue(a);
            }

            br.close();
            fr.close();
            return sieve;

        } 
        catch (IOException ioe) {
            return null;
        }
    }

    public static int repairSieve(int[] sieve) {
        boolean prettyprint = false;

        int size = sieve.length;
        int count = 0;
        String old = Arrays.toString(sieve); // our original array, used to compare to the new one if anything changed

        System.out.println("***Validating a sieve of size " + size + "...***");
        if (prettyprint) {
            System.out.println(old); // prints the original array
        }

        for (int i = 0; i < size; i++) {
            /** Conditions:
             * If the both the index and isPrime function is Prime, then it is valid. (and vice versa)
             * If a mismatch exists:
             *  - we change the value of the index to 0 if it should be a prime number (and vice versa)
             *  - we count the mismatch by 1 and @return count for our total
             */
            if ((Primes.isPrime(i) && sieve[i] == 0 ) || (!Primes.isPrime(i) && sieve[i] == 1 )) {
                //System.out.println("Match: " + sieveIndex + " " + Primes.isPrime(sieveIndex));
            
            } 
            else {
                if (sieve[i] == 1) {
                    if(sieve.length <= 55) { // from sieve.length < 50
                        System.out.println("  (!) Mismatch found at index " + i + ". The value at index " + i + " is " + sieve[i] + ", which should be a prime number (0).");
                    }
                    sieve[i] = 0;
                } 
                else {
                    if(sieve.length <= 55) { // from sieve.length < 50
                        System.out.println("  (!) Mismatch found at index " + i + ". Value is " + sieve[i] + ", which should not be a prime number (1).");
                    }
                    sieve[i] = 1;
                }
                count += 1;
            }
        }

        // Just so we can do a little pretty print
        if (count > 1) {
            System.out.println("  Sieve contained " + count + " error(s).");
            if (prettyprint) {
                System.out.println("\n  Corrected sieve array:\n" + "  " + old + " --> " + Arrays.toString(sieve));
            }
        } 
        else if (count == 0) {
            System.out.println("  Sieve contains no errors!");
        } 
        else {
            System.out.println("  Sieve contained only one error.");
            if (prettyprint) {
                System.out.println("\n  Corrected sieve array:\n" + "  " + old + " --> " + Arrays.toString(sieve));
            }
        }
        System.out.println("------------------------------------------------------------------------------------");

        return count;
    }
    public static void main(String[] args) {
        try{
            // Our sieve files
            int[] sieve5 = readSieve("data/sieve_5.txt");
            int[] sieve10 = readSieve("data/sieve_10.txt");
            int[] sieve55 = readSieve("data/sieve_55.txt");
            int[] sieve100 = readSieve("data/sieve_100.txt");
            int[] sieve1000 = readSieve("data/sieve_1000.txt");
            int[] sieve10000 = readSieve("data/sieve_10000.txt");

            System.out.println("------------------------------------------------------------------------------------");
            
            // Repairing our sieves, if applicable
            repairSieve(sieve5);
            repairSieve(sieve10);
            repairSieve(sieve55);
            repairSieve(sieve100);
            repairSieve(sieve1000);
            repairSieve(sieve10000);

        } catch (IOException ioe) {
            System.out.println("Cannot open/parse through the file");
        }
    }
}
