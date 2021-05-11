package peggame;
import java.util.*;
/**
 * Board of the Peg Game
 */
public class Board implements PegGame {
    private Location[][] gameBoard; // A 2d array of Location
    private List<Move> totalMoves;
    private GameState condition;
    private List<Location> holes;
    private int x; // Row size
    private int y;  // column size
    /**
     * gets the position in the middle of the move
     * @param move move
     * @return middle position
     */
    private Location getMiddlePosition(Move move) {
        Location from = move.getFrom();
        int fromX = from.getRow();
        int fromY = from.getCol();

        Location to = move.getTo();
        int toX = to.getRow();
        int toY = to.getCol();

        //error check the two invalid moves!

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
            if (toY<fromY && fromX>toX) { // topleft
                return gameBoard[fromX-1][fromY-1]; 

            } else if (toY<fromY && fromX<toX) { //topright
                return gameBoard[fromX+1][fromY-1]; 

            } else if (toY>fromY &&fromX>toX){ //bottom left
                return gameBoard[fromX-1][fromY+1]; 

            }  else if (toY>fromY && fromX<toX) { //bottom right
                return gameBoard[fromX+1][fromY+1]; 
            }
        }
        return null;
    }

    /**
     * Creates a 2d array of the board
     * @param size
     */
    public Board(int x, int y, List<Location> holes) {
        this.gameBoard = new Location[x][y];
        this.x = x;
        this.y = y;
        this.condition = GameState.NOT_STARTED;
        this.holes = holes;
        this.totalMoves = new ArrayList<>();
    }

    public void initializeBoard() {
        addHoles();
    }
    /**
     * Sun, Mar 28 - Attempt to reduce time complexity
     * Initializing holes to the board
     */
    private void addHoles() {
        for (int i=0; i<x; i++) {
            for (int j=0;j<y;j++) {
                gameBoard[i][j] = new Location(i,j);
            }
        }

        for (int i = 0; i < holes.size(); i++) {
            gameBoard[holes.get(i).getRow()][holes.get(i).getCol()] = null;
        }
    }

    /**
     * Gets possible moves from where the peg currently is
     * @return potentially a backtracking algorithm
     */
    @Override
    public Collection<Move> getPossibleMoves() {
        int[] possible_x = {-2, -2, -2, 0, 0, 2, 2, 2}; // Getting possible moves the peg can make
        int[] possible_y = {-2, 0, 2, -2, 2, 2, 0, -2};
        List<Move> possibleMoves = new ArrayList<>();

        for (int i=0; i<x;i++) { // going through each peg of the board
            for (int j= 0; j< y; j++) {
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

    /**
     * Gets the current state of the game
     * @return state of the game
     */
    @Override
    public GameState getGameState() {
        if (getPossibleMoves().isEmpty()) {
            int count = 0;
            for (int i=0;i<this.x; i++) {
                for (int j=0; j <this.y; j++) {
                    if (getBoard()[i][j] != null) {
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
        } else if (!getPossibleMoves().contains(move)) {                                                             // move is inside get possible moves
            System.out.println(getPossibleMoves());
            throw new PegGameException("Cannot move a peg one space over.");
        } else {                                                                                                    // move is legitimately valid
            // setting to and from to new values
            gameBoard[fromX][fromY] = null;
            gameBoard[toX][toY] = new Location(toX, toY);
            condition = GameState.IN_PROGRESS;
            totalMoves.add(move);

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
                    gameBoard[fromX+1][fromY-1] = null; 
                } else if (toY>fromY &&fromX>toX){ //bottom left
                    gameBoard[fromX-1][fromY+1] = null; 
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
    public Board deepCopy() {
        Board copy = new Board(this.x, this.y, this.holes);
        Location[][] copyBoard = new Location[gameBoard.length][gameBoard[0].length]; // row, column
        for(int i = 0; i < gameBoard.length; i++) {
            copyBoard[i] = Arrays.copyOf(gameBoard[i], gameBoard[i].length);
        }

        copy.gameBoard = copyBoard; // Setting the copy to be our current board 
        return copy;
    }

    /**
     * Checks if the move is valid within inside the board
     * @param move move
     * @return
     */
    public boolean isValid(Move move) {
        if (move.getTo().getRow() >= 0 && move.getTo().getRow() < this.x && move.getTo().getCol() >= 0 && move.getTo().getCol() < this.y) {
            return true;
        }
        return false;
    }
    
    
    /**
     * Gets an array of the board
     * @return
     */
    public Location[][] getBoard() {
        return gameBoard;
    }

    /**
     * Gets the size of the board
     * @return size of the board x * y
     */
    public int getSize() {
        return x * y;
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
        for(int i = 0; i < gameBoard.length; i++) { // Getting the row length
            for(int j = 0; j < gameBoard[0].length; j++) { // Getting the column length
                if (gameBoard[i][j] == null) {
                    boardString += "-"; // Created if there is nothing on that slot of the array
                } else {
                    boardString += "o"; // Created if there is a Location type (Peg piece) on that slot of the array
                }
            }
            boardString += "\n";
        }
        System.out.println();
        return boardString;
    }

    public static void main(String[] args) throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        board.makeMove(new Move(new Location(0,3), new Location(1,2)));
        System.out.println(board.getGameState());
        System.out.println(board);
    }
    
}