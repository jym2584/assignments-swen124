package parade;

import java.util.Collection;
import java.io.IOException;
import java.util.*;

import backtracker.Backtracker;
import backtracker.Configuration;

public class KnightParade implements Configuration {
    private int row;
    private int col;
    private Chessboard board;

    /**
     * Current position of the knight
     * @param row x positiohn
     * @param col y position
     * @param board board
     */
    public KnightParade(int row, int col, Chessboard board) {
        this.row = row;
        this.col = col;
        this.board = board;
        board.makeMove(row, col); // places the knight on the board
    }
    /**
     * Grabs the possible valid moves from it's current position
     * @return returns the possible moves from it's current position
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        int[] moves_row = {2, 2, -2, -2, 1, 1, -1, -1 };
        int[] moves_col = {-1, 1, 1, -1, 2, -2, 2, -2 };
        
        for(int i = 0; i < moves_row.length; i++) {
            int next_row = row + moves_row[i];
            int next_col = col + moves_col[i];
            Chessboard copy = new Chessboard(board); // makes a copy of the chessboard
            
            if(copy.makeMove(next_row, next_col)) {
                //System.out.println(next_row + ", " + next_col + " is a valid successor");
                successors.add(new KnightParade(next_row, next_col, copy));
            }

            
        }
        return successors;
    }

    /**
     * Automatically returns true since we're already checking for that on getSuccessors
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * If the board has been filled
     */
    @Override
    public boolean isGoal() {
       return board.isFull();
    }

    /**
     * String format for our solution configuration
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int row=0; row<board.getN(); row++) {
            for(int col=0; col<board.getN(); col++) {
                builder.append("[");
                builder.append(String.format("%3d", board.getBoard()[row][col]));
                builder.append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Input for solving the knight problem
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            try {
            System.out.print("Enter N: ");
            String input = scanner.nextLine();
            System.out.print("Enter starting position: ");
            String input2 = scanner.nextLine();
            scanner.close();

            String[] tokens = input2.split(" ");

            Chessboard board = new Chessboard(Integer.parseInt(input));
            KnightParade config = new KnightParade(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), board);
            Backtracker solver = new Backtracker(false);
            Configuration solution = solver.solve(config);

            if(solution == null) {
                System.out.println("No solution.");
            } else {
                System.out.println(solution);
            }

        } catch (NumberFormatException nfe) {
            System.out.println("An invalid input was made. Make sure the inputs contain only integers!\n  - N should contain only one number (eg: 5).\n  - Starting position should contain 2 numbers (eg: 4 4).");
        }


    }

    
}
