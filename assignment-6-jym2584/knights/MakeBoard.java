package knights;
import graphs.*;
import java.util.*;
/**
 * Makes a chess board using Squares
 */
public class MakeBoard {
    private final int rows;
    private final int columns;
    private Square[][] board_array;

    /**
     * Initialization of makeBoard
     * @param rows number of rows
     * @param columns number of columns
     */
    public MakeBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board_array = new Square[rows][columns];
    }
    
    public Square[][] getBoard() { return board_array; }

    /**
     * adds each Square onto the board_array
     * @return a graph of squares
     */
    public Graph<Square> makeBoard() {
        Graph<Square> board = new AdjacencyGraph<>();
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                Square square = new Square(i, j);
                    board.add(square);
                    board_array[i][j] = square;
            }
        }
        return board;
    }

    /**
     * Connects possible moves using graphs data structure
     * @param board our chess board with size row and column
     * @param x Initial X starting position of the knight
     * @param y Initial Y starting position of the knight
     */
    public void connectMovesFromStart(int x, int y, Graph<Square> board) { 
        int[] moves_row = { 2, 2, -2, -2, 1, 1, -1, -1 };
        int[] moves_col = { -1, 1, 1, -1, 2, -2, 2, -2 };
        Square startingPosition = board_array[x][y];

        for(int j = 0; j < moves_row.length; j++) {  // Searching for possible moves based on the starting position
            int moves_x = x + moves_row[j];
            int moves_y = y + moves_col[j];
            
            if(isValid(moves_x, moves_y, board_array.length, board_array[0].length)) { // If the possible moves are within the board x and y range
                Square endingPosition = board_array[moves_x][moves_y];
                board.connectDirected(startingPosition, endingPosition); // Connect the vertexes/paths
                //System.out.println("Connected " + startingPosition + " to" + " " + endingPosition);
                
                
                for(int k = 0; k < moves_row.length; k++) { // I'm sorry.
                    int movesX2 = moves_x + moves_row[k];
                    int movesY2 = moves_y + moves_col[k];
                    if(isValid(movesX2, movesY2, board_array.length, board_array[0].length)) { 
                        Square endingPosition2 = board_array[movesX2][movesY2];
                        board.connectDirected(endingPosition, endingPosition2);
                        //System.out.println("Connected " + endingPosition + " to" + " " + endingPosition2);


                        for(int l = 0; l < moves_row.length; l++) { // I'm sorry sorry.
                            int movesX3 = movesX2 + moves_row[l];
                            int movesY3 = movesY2 + moves_col[l];
                            if(isValid(movesX3, movesY3, board_array.length, board_array[0].length)) { 
                                Square endingPosition3 = board_array[movesX3][movesY3];
                                board.connectDirected(endingPosition2, endingPosition3);
                                //System.out.println("Connected " + endingPosition2 + " to" + " " + endingPosition3);

                                for(int m = 0; m < moves_row.length; m++) { // I'm sorry*3.
                                    int movesX4 = movesX3 + moves_row[m];
                                    int movesY4 = movesY3 + moves_col[m];
                                    if(isValid(movesX4, movesY4, board_array.length, board_array[0].length)) { 
                                        Square endingPosition4 = board_array[movesX4][movesY4];
                                        board.connectDirected(endingPosition3, endingPosition4);
                                        //System.out.println("Connected " + endingPosition2 + " to" + " " + endingPosition3);
                                    }
                                }
                            }
                        }

                    }
                }
                
            }
        }
    }




    /**
     * Checks if the move is valid within inside the board
     * @param move_x current position
     * @param move_y end position
     * @param board_x board length
     * @param board_y board width
     * @return
     */
    public static boolean isValid(int move_x, int move_y, int boardSize_x, int boardSize_y) {
        if ( move_x >= 0 && move_x < boardSize_x && move_y >= 0 && move_y < boardSize_y) {
            return true;
        } else {
            return false;
        }
    }

}
