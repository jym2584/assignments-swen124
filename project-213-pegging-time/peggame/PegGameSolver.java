package peggame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import peggame.provided.backtracker.Backtracker;
import peggame.provided.backtracker.Configuration;


/**
 * Backtracking algo for Peg Game
 */
public class PegGameSolver implements Configuration{
    private PegGame gameboard;
    private List<Move> solutionMoves;
    private List<PegGame> pegGameStrings;

    /**
     * Class for our configuration
     * @param gameboard board array
     * @param solutionMoves list of moves that lead to the solution
     * @param pegGameStrings list of strings from the gameboard that lead to the solution
     */
    public PegGameSolver(PegGame gameboard, List<Move> solutionMoves, List<PegGame> pegGameStrings){
        this.gameboard = gameboard;
        this.solutionMoves = solutionMoves;
        this.pegGameStrings = pegGameStrings;
    } 

    /**
     * Passing in default parameters for solutionmoves and peggameStrings
     * @param gameboard
     */
    public PegGameSolver(PegGame gameboard) {
        this(gameboard, new ArrayList<>(), new ArrayList<>());
    }


    /**
     * Getting possible moves from a given point
     * @return returns a list of possible moves
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Move> solutionMovesCopy = new ArrayList<>(); //List of Moves
        List<PegGame> solutionStringsCopy = new ArrayList<>(); //List of Peggames and its toString

        List<Configuration> successors = new ArrayList<>(); //List of Valid Moves(Successors) 
        Collection<Move> moves = gameboard.getPossibleMoves(); //Collection of Moves that are a possible on the board
        for (Move move: moves) { //Iterates through the collection 
            PegGame copy = gameboard.deepCopy(); //Makes a deep copy of the gameboard being used
            solutionMovesCopy = new ArrayList<>(solutionMoves);
            solutionStringsCopy = new ArrayList<>(pegGameStrings);

            try {
                copy.makeMove(move); //attempts to make a move on the deep copy
                solutionMovesCopy.add(move); //adds move to list of moves
                solutionStringsCopy.add(copy); //adds deepy copy to list
                successors.add(new PegGameSolver(copy, solutionMovesCopy, solutionStringsCopy));  // adds Constructor of this class to the successors
            } catch (PegGameException e) {
                System.err.print(e.getMessage()); //prints error messages
            }
        }
        this.solutionMoves = solutionMovesCopy;
        this.pegGameStrings = solutionStringsCopy;
        return successors;

    }

    /**
     * @return always returns true since we are checking for valid moves on our getSuccessors
     */
    @Override
    public boolean isValid() {
        return true; //Checking of valid moves and board isn done within PegGame/Board
    }

    /**
     * Valid configuration returns if won
     * @return true if the peggame results in a won condition
     */
    @Override
    public boolean isGoal() {
        gameboard.getGameState(); // updates the game state after the current move
        if (gameboard.getGameState() == GameState.WON) {
            return true;
        }
        return false;
    }

    /**
     * Gets a list of moves for our valid solution
     * @return
     */
    public List<Move> getSolution() {
        return solutionMoves;
    }

    /**
     * Gets a list of the board from each move for our valid solution
     * @return
     */
    public List<PegGame> getPegGameStrings() {
        return pegGameStrings;
    }

    @Override
    public String toString() {
        return gameboard.toString();
    }

    // manual testing
    public static void main(String[] args) throws IOException {
        PegGame board = TriangleFile.makeBoard("triangleData/5.txt");
        PegGameSolver config = new PegGameSolver(board);        
        Backtracker solver = new Backtracker(false);
        Configuration solution = solver.solve(config);

        if(solution == null) {
            System.out.println("No Solution Found!");
        }
        else {
            System.out.println(solution);
        }

        config = (PegGameSolver) solver.solve(config);

        System.out.println(config.getSolution()); // Getting complete list of moves
        System.out.println(config.getPegGameStrings().get(0)); // Getting the first move 
        //System.out.println(config.getPegGameStrings()); // Getting complete list of Strings
                                                          // There are empty spaces when printing this entire thing out.
                                                          // Might be due to the newlines after the last row
        
    }
    
}