package knights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.*;

import graphs.*;

/**
 * Grabbing input for DFS/BFS search
 */

public class KnightsMoves {
    public static void main(String[] args) {

        // Grabbing input for making the board
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        System.out.println(Arrays.toString(tokens));
        MakeBoard new_board = new MakeBoard(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        Graph<Square> board = new_board.makeBoard();
        
        // Grabbing input for starting and ending coordinates
        boolean noQuit = true;
        while(noQuit) {
            System.out.print("Enter the start and end coordinates: ");
            String input2 = scanner.nextLine();

            if(input2.equals("quit")) {
                noQuit = false;
                System.out.println("Goodbye!");
                break;
            }
            try {
            String[] tokens2 = input2.split(" ");
            System.out.println(Arrays.toString(tokens2));
            
            // Grabs the start and end coordinatse
            Square start = new_board.getBoard()[Integer.parseInt(tokens2[0])][Integer.parseInt(tokens2[1])];
            Square end = new_board.getBoard()[Integer.parseInt(tokens2[2])][Integer.parseInt(tokens2[3])];
            
            // Connects possible moves from the start coordinate
            new_board.connectMovesFromStart(Integer.parseInt(tokens2[0]), Integer.parseInt(tokens2[1]), board);

            // Prints out df/bfPaths
            List<Square> dfPath = board.dfPath(start, end);
            System.out.println("DFS: " + dfPath);
            List<Square> bfPath = board.bfPath(start, end);
            System.out.println("BFS: " + bfPath);
            
            } catch (ArrayIndexOutOfBoundsException aioe) {
                System.out.println("Input is out of range. Enter a valid input that is in range from x: 0-" + (Integer.parseInt(tokens[0])-1) + " and y: 0-" + (Integer.parseInt(tokens[0])-1));
            } catch (NumberFormatException nfe) {
                System.out.println("Input contains only strings which is invalid. Required input: starting_x starting_y ending_x ending_y");
            }
        }
        scanner.close();

    }    
}
