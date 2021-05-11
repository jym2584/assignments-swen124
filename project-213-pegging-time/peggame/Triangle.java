package peggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Triangle implements PegGame {
    private Location[][] gameBoard;
    private List<Move> totalMoves;
    private GameState condition;
    private List<Location> holes;
    private int size;

    public Triangle (int size, List<Location> holes) {
        this.size = size;
        this.condition = GameState.NOT_STARTED;
        this.holes = holes;
        this.gameBoard = new Location[size][];
    }
    ///////////////////////////////// START OF BOARD INITIALIZATION /////////////////////////////////

    /**
     * MUST CALL THIS TO FULLY INITIALIZE THE TRIANGLE
     */
    public void initializeBoard() {
        makeTriangle();
        makeLocation();
        addHoles();
    }

        /**
         * TRIANGLE INITIALIZATION
         * Adds empty arrays to the triangle
         */
        private void makeTriangle() {
            for(int i = 0; i < size; i++) {
                gameBoard[i] = new Location[i+1];
            }
        }

        /**
         * TRIANGLE INITIALIZATION
         * Adds a location to every index of the array
         */
        private void makeLocation() {
            for(int i = 0; i < size ; i++) { // row
                for(int j = 0; j < gameBoard[i].length; j++) { // column
                    gameBoard[i][j] = new Location(i, j);
                }
            }
        }

        /**
         * TRIANGLE INITIALIZATION
         * Initializing holes to the board
         */
        private void addHoles() {
            if(!holes.isEmpty()) {
                for (int i = 0; i < holes.size(); i++) {
                    gameBoard[holes.get(i).getRow()][holes.get(i).getCol()] = null;
                }
            }
        }

    /////////////////////////////////// END OF BOARD INITIALIZATION ///////////////////////////////////

    private Location getMiddlePosition(Move move) {
        Location from = move.getFrom();
        int fromX = from.getRow();
        int fromY = from.getCol();

        Location to = move.getTo();
        int toX = to.getRow();
        int toY = to.getCol();

        if (fromX == toX) { // vertical jump
            if (fromY > toY) {
                return gameBoard[fromX][fromY-1];
            } else {
                return gameBoard[fromX][toY-1];
            }
        } else if (fromY == toY) { // horizontal jump
            if (fromX > toX) {
                return gameBoard[fromX-1][toY];
            } else {
                return gameBoard[toX-1][toY];
            }
        } else {
            if (toX > fromX) { // going down
                if (toY>fromY){ // right
                    return gameBoard[fromX+1][fromY+1]; 
                }  else if (toY<fromY) { // left
                    return gameBoard[fromX+1][fromY-1]; 
                }
            } else if (toX < fromX) { // going up
                if (toY>fromY) { // right
                    return gameBoard[fromX-1][fromY+1]; 
    
                } else if (toY<fromY) { // left
                    return gameBoard[fromX-1][fromY-1]; 
    
                }
            }
        }
        return null;
    }


    @Override
    public Collection<Move> getPossibleMoves() {
        int[] possible_x = {-2, 0, 0, 2, 2, -2}; // Getting possible moves the peg can make
        int[] possible_y = {0, -2, 2, 0, 2, -2};
        List<Move> possibleMoves = new ArrayList<>();

        for (int i=0; i<size;i++) { // going through each peg of the board
            for (int j= 0; j< i+1; j++) {
                Location from = new Location(i,j);
                int fromX = from.getRow();
                int fromY = from.getCol();
                
                for(int k = 0; k < possible_x.length; k++) { // looping over possible moves
                    Location possibleTo = new Location(possible_x[k] + fromX, possible_y[k] + fromY);
                    int toX = possibleTo.getRow();
                    int toY =  possibleTo.getCol();
                    Move move = new Move(from, possibleTo); // Getting the possible moves from K

                    if (gameBoard[fromX][fromY] != null && isValid(move) && getMiddlePosition(move) != null && gameBoard[toX][toY] == null) { // If the possible moves are valid 
                        possibleMoves.add(move); // Add the possible move 
                    }
                }
            }
        }

        return possibleMoves;
    }

    @Override
    public GameState getGameState() {
        if (getPossibleMoves().isEmpty()) {
            int count = 0;
            for (int i=0;i<size; i++) {
                for (int j=0; j <i+1; j++) {
                    if (getGameBoard()[i][j] != null) {
                        count++;
                    } 
                }
            }
            if (count > 1) {
                condition = GameState.STALEMATE;
            }
            else {
                condition = GameState.WON;
            }
        }
        return this.condition;
    }

    /**
     * Making a move
     * @param move has to take in from and to locations
     * @throws PegGameException if a move is invalid
     */
    @Override
    public void makeMove(Move move) throws PegGameException {
        Location from = move.getFrom();
        int fromX = from.getRow();
        int fromY = from.getCol();

        Location to = move.getTo();
        int toX = to.getRow();
        int toY = to.getCol();

        /**
         * Checks if the move is valid
         */
        if (!isValid(move)) {                                                                                       // move inside board
            throw new PegGameException("Move is not inside the dimensions of the board");
        } else if (from.equals(to)) {                                                                               // from is different than to
            throw new PegGameException("Not moving the peg at all."); 
        } else if (gameBoard[fromX][fromY] == null) {                                                               // from is a peg not a space
            throw new PegGameException("There is an empty space at the location: " + fromX + ", " + fromY);
        } else if (gameBoard[toX][toY] != null) {                                                                   // to is a space not a peg
            throw new PegGameException("There is already a peg at location: " + toX + ", " + toY);
        } else if (getMiddlePosition(move) == null) {                                                               // jumped over peg is a peg not a space
            throw new PegGameException("The peg you are trying to jump over does not exist.");
        } else if (toY<fromY && fromX<toX) { //topright
            throw new PegGameException("Cannot move 2 spaces over");
        } else if (toY>fromY &&fromX>toX){ //bottom left
            throw new PegGameException("Cannot move 2 spaces over");
        } else if (!getPossibleMoves().contains(move)) {                                                             // move is inside get possible moves
            throw new PegGameException("Cannot move a peg one space over.");
        } else {                                                                                                    // move is legitimately valid
            // setting to and from to new values
            gameBoard[fromX][fromY] = null;
            gameBoard[toX][toY] = new Location(toX, toY);
            condition = GameState.IN_PROGRESS;

            /**
             * clearing the middle peg
             */
            if (fromX == toX) { // vertical jump
                if (fromY > toY) {
                    gameBoard[fromX][fromY-1] = null;
                } else {
                    gameBoard[fromX][toY-1] = null;
                }
            } else if (fromY == toY) { // horizontal jump
                if (fromX > toX) {
                    gameBoard[fromX-1][toY] = null;
                } else {
                    gameBoard[toX-1][toY] = null;
                }
            } else { // diagonal jump
                if (toY<fromY && fromX>toX) { //topleft
                    gameBoard[fromX-1][fromY-1] = null; 
                
                } else if (toY<fromY && fromX<toX) { //topright
                    throw new PegGameException("Cannot move 2 spaces over");
                
                } else if (toY>fromY &&fromX>toX){ //bottom left
                    throw new PegGameException("Cannot move 2 spaces over");
                
                }  else if (toY>fromY && fromX<toX) { //bottom right
                    gameBoard[fromX+1][fromY+1] = null; 
                }
            }
        }

    }

    /**
     * @return deep copy of the current state of the board
     */
    @Override
    public Triangle deepCopy() {
        Triangle copy = new Triangle(size, this.holes);
        Location[][] copyBoard = new Location[gameBoard.length][]; // row, column
        for(int i = 0; i < gameBoard.length; i++) {
            copyBoard[i] = Arrays.copyOf(gameBoard[i], gameBoard[i].length);
        }

        copy.gameBoard = copyBoard; // Setting the copy to be our current board 
        return copy;
    }

    public boolean isValid(Move move) {
        if (move.getTo().getCol() == 0 && move.getTo().getRow() == 0) {
            return true;
        } else if (move.getTo().getRow() >= 0 && move.getTo().getRow() < size) {
            if (move.getTo().getCol() >= 0 && move.getTo().getCol() <= move.getTo().getRow()) {
                return true;
            }
            return false;
        } else {        
            return false;
        }
    }

    public GameState getCondition() {
        return condition;
    }
    public Location[][] getGameBoard() {
        return gameBoard;
    }
    public List<Location> getHoles() {
        return holes;
    }
    public int getSize() {
        return size;
    }
    public List<Move> getTotalMoves() {
        return totalMoves;
    }

    /**
     * Prints out a stringified version of the board
     * @return returns a stringified version of the board
     */
    @Override
    public String toString() {
        String boardString = "";
        for(int i = 0; i < size; i++) { // Getting the row length
            for (int j = size; j >= i; j--) {
                boardString += " ";
            }

            for(int j = 0; j < i + 1; j++) { // Getting the column length
                if (gameBoard[i][j] == null) {
                    boardString += "- "; // Created if there is nothing on that slot of the array
                } else {
                    boardString += "o "; // Created if there is a Location type (Peg piece) on that slot of the array
                }
            }
            boardString += "\n";
        }
        System.out.println();
        return boardString;
    }

    public String printUnformattedString() {
        String boardString = "";
        for(int i = 0; i < size; i++) { // Getting the row length
            boardString += "  ";
            for(int j = 0; j < i + 1; j++) { // Getting the column length
                if (gameBoard[i][j] == null) {
                    boardString += "- "; // Created if there is nothing on that slot of the array
                } else {
                    boardString += "o "; // Created if there is a Location type (Peg piece) on that slot of the array
                }
            }
            boardString += "\n";
        }
        System.out.println();
        return boardString;
    }


    ///////////////////////////////// Outputs for debugging ///////////////////////////////////////////////////
    /**
     * Moves for output_5B.txt
     * @return returns an arraylist of moves from output_5B
     */
    private static final List<Move> output5bMoves = new ArrayList<>(); static {
        //output5bMoves.add(new Move(new Location(1,1), new Location(0,0)));                                Throws Exception Error. "The peg you are trying to jump over does not exist."
        //output5bMoves.add(new Move(new Location(2,2), new Location(4,0)));                                Throws Exception Error. "Cannot move 2 spaces over."
        output5bMoves.add(new Move(new Location(2,0), new Location(0,0))); // Move from (2, 0) to (0, 0)
        output5bMoves.add(new Move(new Location(4,0), new Location(2,0))); // Move from (4, 0) to (2, 0)
        output5bMoves.add(new Move(new Location(3,2), new Location(3,0))); // Move from (3, 2) to (3, 0)
        output5bMoves.add(new Move(new Location(3,0), new Location(1,0))); // Move from (3, 0) to (1, 0)
        output5bMoves.add(new Move(new Location(0,0), new Location(2,0))); // Move from (0, 0) to (2, 0)
        output5bMoves.add(new Move(new Location(1,1), new Location(3,1))); // Move from (1, 1) to (3, 1)
        output5bMoves.add(new Move(new Location(4,1), new Location(2,1))); // Move from (4, 1) to (2, 1)
        output5bMoves.add(new Move(new Location(4,3), new Location(4,1))); // Move from (4, 3) to (4, 1)
        output5bMoves.add(new Move(new Location(3,3), new Location(1,1))); // Move from (3, 3) to (1, 1)
        output5bMoves.add(new Move(new Location(1,1), new Location(3,1))); // Move from (1, 1) to (3, 1)
        output5bMoves.add(new Move(new Location(2,0), new Location(4,2))); // Move from (2, 0) to (4, 2)
        output5bMoves.add(new Move(new Location(4,1), new Location(4,3))); // Move from (4, 1) to (4, 3)
        output5bMoves.add(new Move(new Location(4,4), new Location(4,2))); // Move from (4, 4) to (4, 2)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0,0));
        PegGame board = new Triangle(5, holes);
        ((Triangle)board).initializeBoard();

        /**
         * Making moves from output_5B
         */
        for(Move move: output5bMoves) {
            ((Triangle)board).makeMove(move);
            System.out.println(move);
            System.out.println("Formatted: \n" + board); // Printing board
            System.out.println("Unformatted: \n" + ((Triangle)board).printUnformattedString()); // Printing unformatted
        }

    }
    
}
