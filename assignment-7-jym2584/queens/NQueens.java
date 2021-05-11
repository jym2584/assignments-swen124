package queens;

import java.util.Arrays;
import java.util.Collection;
import java.util.*;

import backtracker.Backtracker;
import backtracker.Configuration;

public class NQueens implements Configuration {
    private Queen[] queens;
    private int n;

    public NQueens(int n, Queen[] queens) {
        this.n = n;
        this.queens = queens;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        int row = queens.length;
        for(int col = 0; col < n; col++) {
            Queen[] new_queens = Arrays.copyOf(queens, queens.length+1); // creates a queen on each possible column
            new_queens[row] = new Queen(row, col);
            System.out.println(new_queens[row]);
            System.out.println("Queens Length: " + row);
            successors.add(new NQueens(n, new_queens));
        }
        return successors;

    }

    @Override
    public boolean isValid() { // Pruning
        if(queens.length == 0 ) {
            return true;
        }
        Queen new_queen = queens[queens.length-1];
        for(int i = 0; i < queens.length - 1; i++) {
            if (new_queen.canAttack(queens[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        if(isValid() && n == queens.length) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String[][] board = new String[n][n];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                board[row][col] = " ";
            }
        }

        for (Queen queen: queens) {
            board[queen.getRow()][queen.getColumn()] = "Q";
        }

        StringBuilder str = new StringBuilder("");
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                str.append("[" + board[row][col] + "]");
            }
            str.append("\n");
        }

        return str.toString();



    }

    public static void main(String[] args) {
       Queen[] queens = {new Queen(0, 0)};
        NQueens config = new NQueens(4, new Queen[0]);
        System.out.println(config);
//
        for(Configuration successor: config.getSuccessors()) {
            System.out.println("Successor");
            System.out.println(successor);
        }
//
        System.out.println(config.isValid());
        System.out.println("Goal " + config.isGoal());


       //Backtracker solver = new Backtracker(false);
       //Configuration solution = solver.solve(new NQueens(4, new Queen[0]));
       //System.out.println(solution);
    }
    
}
