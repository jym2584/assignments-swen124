package peggame.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import peggame.*;

@Testable
public class TriangleTest {
    
    /**
     * Creating an empty board
     */
    @Test
    public void emptyBoardSize5() {
        String expected = "      o \n" +
                          "     o o \n" +
                          "    o o o \n" +
                          "   o o o o \n" +
                          "  o o o o o \n";
        Triangle board = new Triangle(5, new ArrayList<>());
        board.initializeBoard();

        assertEquals(expected, board.toString());
    }

    @Test
    public void moveOnceString() throws PegGameException {
        String expected = "      o \n" +
                          "     o - \n" +
                          "    o o - \n" +
                          "   o o o o \n" +
                          "  o o o o o \n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 0));
        Triangle board = new Triangle(5, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2, 2), new Location(0, 0)));

        assertEquals(expected, board.toString());
    }

    @Test
    public void moveTwiceString() throws PegGameException {
        String expected = "      o \n" +
                          "     o - \n" +
                          "    - - o \n" +
                          "   o o o o \n" +
                          "  o o o o o \n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 0));
        Triangle board = new Triangle(5, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2, 2), new Location(0, 0)));
        board.makeMove(new Move(new Location(2, 0), new Location(2, 2)));

        assertEquals(expected, board.toString());
    }

    /**
     * Testing for deep copies
     * @throws PegGameException
     */
    @Test
    public void deepCopyTest() throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0,0));
        Triangle board = new Triangle(5, holes);
        board.initializeBoard();

        Triangle new_board = board.deepCopy();
        System.out.println(new_board);
        System.out.println(board);
    }

    /**
     * Testing to see if making a move on the deep copy also doesn't make a move on the original
     * @throws PegGameException
     */
    @Test
    public void deepCopyMoveTest() throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0,0));
        Triangle board = new Triangle(5, holes);
        board.initializeBoard();

        Triangle new_board = board.deepCopy();
        System.out.println(new_board);
        System.out.println(board);
        new_board.makeMove(new Move(new Location(2,0), new Location(0,0)));
        System.out.println(new_board);
        System.out.println(board);

    }

    /**
     * Testing to see if making a move on the board, then making a deep copy and making another move on the board are different
     * @throws PegGameException
     */
    @Test
    public void deepCopyMoveCopyMoveTest() throws PegGameException {
        String expected = "      - \n" +
                          "     o o \n" +
                          "    o o o \n" +
                          "   o o o o \n" +
                          "  o o o o o \n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 0));
        Triangle board = new Triangle(5, holes);
        board.initializeBoard();
        assertEquals(expected, board.toString());

        String expectedCopy = "      o \n" +
                              "     o - \n" +
                              "    o o - \n" +
                              "   o o o o \n" +
                              "  o o o o o \n";

        Triangle copy = board.deepCopy();
        copy.makeMove(new Move(new Location(2, 2), new Location(0, 0)));
        assertEquals(expectedCopy, copy.toString());
        assertNotEquals(board.toString(), copy.toString());

        String expectedMove = "      o \n" +
                              "     o - \n" +
                              "    - - o \n" +
                              "   o o o o \n" +
                              "  o o o o o \n";

        
        board.makeMove(new Move(new Location(2, 2), new Location(0, 0)));
        board.makeMove(new Move(new Location(2, 0), new Location(2, 2)));

        assertEquals(expectedMove, board.toString());
        assertNotEquals(board.toString(), copy.toString());
    }

    
    /**
     * Testing to see if CLI works as well as other methods such as GetPossibleMoves and GetMiddle
     */
    public static void main(String[] args) throws IOException, NumberFormatException, PegGameException{
        boolean noQuit = true;
        String input = "";
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        input = scanner.nextLine();
        try{
            PegGame board = TriangleFile.makeBoard(input);
            System.out.println(board);

            while(noQuit) { // while the input isn't valid
                try {
                    Command.playGame(board);
                    noQuit = false;

                } catch (ArrayIndexOutOfBoundsException aiobe) {
                    System.out.println("Invalid input. Try again or type help for a list of commands.");
                } 
            }
            
            scanner.close();

        } catch (IOException pge) {
            System.out.println(input + "is an invalid filename. Exiting program.");
        }
    }
}
