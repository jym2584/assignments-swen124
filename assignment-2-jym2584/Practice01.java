import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Practice01 {
    public static String arrayToString(int[] array) {
        return Arrays.toString(array);
    }

    public static int printLines(String filename, String letter) throws IOException {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            //line = line.toLowerCase();
            int count = 0;

            while (line != null) {
                //for (int i = 0; i < line.length(); i++) {
                    if (line.length() == 0) {
                    } else if (line.toLowerCase().charAt(0) == letter.charAt(0)) {
                        System.out.println(line);
                        count++;
                    }
                //}
                line = br.readLine();
                //System.out.println(line);
            }
            br.close();
            fr.close();
            System.out.println("\n***** Printed " + count + " instances of " + letter + " *****\n");
            return count;
        
        }
        catch (IOException ioe) {
            System.out.println("Cannot read the file.");
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        String array2string = arrayToString(array);
        System.out.println(array2string);
        try {
        String alice = "data/alice.txt";
        printLines(alice, "e");
        printLines(alice, "j");
        printLines(alice, "k");
        } catch(IOException ioe) {
            System.out.println("Cannot open file");
        }
    }

}