package peggame.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import peggame.*;
import java.util.*;

/**
 * Testing file for various exceptions for PegGame
 */
@Testable
public class PegGameExceptionTest {
    /**
     * Testing the toString
     */
    @Test
    public void testException() {
        String message = "Test Passed";
        Exception exception = new PegGameException(message);
        assertEquals(message, exception.getMessage());
    }
    /**
     * Testing invalid move
     * @throws PegGameException if an invalid move was made
     */
    @Test
    public void testNotValidException() throws PegGameException {
        try {
            List<Location> holes = new ArrayList<>();
                holes.add(new Location(0, 3));
            Board board = new Board(4, 4, holes);
            board.initializeBoard();

            board.makeMove(new Move(new Location(0,3), new Location(10000,10000)));

        } catch (PegGameException pge) {
            String expected = "Move is not inside the dimensions of the board";
            assertEquals(expected, pge.getMessage());
        }
    }

    /**
     * Testing exception if the peg doesn't move
     * @throws PegGameException if the peg doesn't move
     */
    @Test
    public void testNotMoving() throws PegGameException {
        try {
            List<Location> holes = new ArrayList<>();
                holes.add(new Location(0, 3));
            Board board = new Board(4, 4, holes);
            board.initializeBoard();

            board.makeMove(new Move(new Location(0,3), new Location(0,3)));

        } catch (PegGameException pge) {
            String expected = "Not moving the peg at all.";
            assertEquals(expected, pge.getMessage());
        }
    }
    
    /**
     * Testing for empty space
     * @throws PegGameException if there is an empty slot at the location
     */
    @Test
    public void testEmptySpaceException() throws PegGameException {
        try {
            List<Location> holes = new ArrayList<>();
                holes.add(new Location(0, 3));
            Board board = new Board(4, 4, holes);
            board.initializeBoard();

            board.makeMove(new Move(new Location(0,3), new Location(0,1)));

        } catch (PegGameException pge) {
            String expected = "There is an empty space at the location: 0, 3";
            assertEquals(expected, pge.getMessage());
        }
    }

    /**
     * Testing if there is a peg at a location
     * @throws PegGameException if a peg is present at the attempted move
     */
    @Test
    public void testPegAlreadyAtLocationException() throws PegGameException {
        try {
            List<Location> holes = new ArrayList<>();
                holes.add(new Location(0, 3));
            Board board = new Board(4, 4, holes);
            board.initializeBoard();

            board.makeMove(new Move(new Location(2,1), new Location(0,3)));
            board.makeMove(new Move(new Location(2,0), new Location(0,3)));

        } catch (PegGameException pge) {
            String expected = "There is already a peg at location: 0, 3";
            assertEquals(expected, pge.getMessage());
        }
    }

    /**
     * Testing if the peg doesn't exist
     * @throws PegGameException the peg doesn't exist
     */
    @Test
    public void testPegOneSpaceOver() throws PegGameException {
        try {
            List<Location> holes = new ArrayList<>();
                holes.add(new Location(0, 3));
            Board board = new Board(4, 4, holes);
            board.initializeBoard();

            board.makeMove(new Move(new Location(0,2), new Location(0,3)));

        } catch (PegGameException pge) {
            String expected = "Cannot move a peg one space over.";
            assertEquals(expected, pge.getMessage());
        }
    }
    @Test
    public void testPegMiddleIsNull() throws PegGameException {
        try {
            List<Location> holes = new ArrayList<>();
                holes.add(new Location(0, 3));
            Board board = new Board(4, 4, holes);
            board.initializeBoard();

            board.makeMove(new Move(new Location(2,1), new Location(0,3)));
            board.makeMove(new Move(new Location(0,3), new Location(1,2)));

        } catch (PegGameException pge) {
            String expected = "The peg you are trying to jump over does not exist.";
            assertEquals(expected, pge.getMessage());
        }
    }
    
    /**
     * Just testing if the exception runs properly
     * @param args
     * @throws PegGameException
     */
    public static void main(String[] args) throws PegGameException {
        throw new PegGameException("Test Passed");
    }
}
