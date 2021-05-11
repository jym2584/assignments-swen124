package connectfour.model;

import java.util.HashSet;
import java.util.Set;

public class ConnectFour {
    /**
     * The number of rows in a connect four board.
     */
    public static final int ROWS = 6;

    /**
     * The number of columns in a connect four board.
     */
    public static final int COLS = 6;

    /**
     * The board on which the game is played.
     */
    private final Checker[][] board;

    /**
     * Used to count the number of checkers in each column.
     */
    private final int[] checkersInColumn;

    /**
     * Keeps track of the moves made.
     */
    private int moves;

    /**
     * The current player's turn.
     */
    private Checker currentPlayer;






    public ConnectFour() {
        board = new Checker[COLS][ROWS];
        checkersInColumn = new int[COLS];
        observers = new HashSet<>();
    
        reset();
    }



    

    /**
     * Observers
     */
    private Set<CheckerObserver> observers;

    public void register(CheckerObserver o) {
        observers.add(o);
    }

    public void deregister(CheckerObserver o) {
        observers.remove(o);
    }

    private void notifyObservers(int col, int row) {
        for (CheckerObserver o: observers) {
            o.checkerChanged(this, col, row);
        }
    }












    /**
     * Returns the number of moves that have been made in this game.
     * 
     * @return The number of moves made so far in this game.
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Returns the number of moves remaining before the board is full.
     * 
     * @return The number of moves remaining before the board is full.
     */
    public int getRemainingMoves() {
        return (ROWS * COLS) - moves;
    }

    /**
     * Attempts to make a move in the specified column for the current player.
     * 
     * @param column The column in which the move is being made.
     * @throws ConnectFourException If the move is invalid because the column
     * is full or the column is out of range.
     */
    public void move(int column) throws ConnectFourException {
        // validate the column
        if(column < 0 || column >= COLS) {
            throw new ConnectFourException("Invalid column: " + column);
        } else if( checkersInColumn[column] == ROWS) {
            throw new ConnectFourException("Column is full: " + column);
        }

        // increment the number of checkers in the row...
        checkersInColumn[column]++;
        // and set the checker to the player's color
        int row = ROWS - checkersInColumn[column];
        board[column][row] = currentPlayer;
        moves++;
        notifyObservers(column, row);

        // if no win, switch turns
        currentPlayer = currentPlayer == Checker.BLACK ? Checker.RED : Checker.BLACK;
    }

    /**
     * Returns the current player.
     * 
     * @return The color of the current player.
     */
    public Checker getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the Checker at the specified location on the board.
     * 
     * @param col The column of the Checker.
     * @param row The row of the Checker.
     * @return The Checker at the specified column and row.
     */
    public Checker getChecker(int col, int row) {
        return board[col][row];
    }

    public int[] getCheckersInColumn() {
        return checkersInColumn;
    }

    /**
     * Resets the board so that all squares are empty.
     */
    public void reset() {
        for(int col=0; col<board.length; col++) {
            checkersInColumn[col] = 0;
            for(int row=0; row<board[col].length; row++) {
                board[col][row] = Checker.NONE;
                notifyObservers(col, row);
            }
        }
        currentPlayer = Checker.BLACK;
        moves = 0;
    }
}
