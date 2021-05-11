package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TriangleFile {
    /**
     * Makes the board from a file
     * @param filename filename
     * @return returns a board based on how many holes were made
     * @throws IOException If an invalid file is given
     * @throws PegGameException if an invalid move is given
     */
    public static Triangle makeBoard (String filename) throws IOException {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            int size = Integer.parseInt(line);
            int lineCount = 0; // Initializing x-ish
            int y = 0; // initializing y 
            List<Location> holes = new ArrayList<>();
            // reads the file into size n and where the holes are
            line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split("");
                y = tokens.length;
                for (int i = 0; i < y; i++) {
                    if (tokens[i].equals(".")) {
                        holes.add(new Location(lineCount, i));
                    }
                }
                line = reader.readLine(); // updates to next line
                lineCount++;
            } 

            reader.close();

            /**
             * Sun, Mar 28 - Attempt to reduce time complexity
             * Initializing holes to the board
             */
            Triangle board = new Triangle(size, holes);
            board.initializeBoard(); // Adding holes to the board
            return board;

        } catch (IOException ioe)  {
            throw new IOException("File not found");
        }
    }

    public static void main(String[] args) throws PegGameException {
        try {
            Triangle board = makeBoard("triangleData/4.txt");
            System.out.println(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
