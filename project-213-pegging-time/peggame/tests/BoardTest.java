package peggame.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import peggame.*;

/**
 * Board Testing
 */
@Testable
public class BoardTest {
    /**
     * Creating an empty board
     */
    @Test
    public void emptyBoard() {
        String expected = "ooooo" + "\n" +
                        "ooooo" + "\n" +
                        "ooooo" + "\n" + 
                        "ooooo" + "\n" +
                        "ooooo" + "\n";
        Board board = new Board(5, 5, new ArrayList<>());
        board.initializeBoard();

        assertEquals(expected, board.toString());
    }

    @Test
    public void moveOnceString() throws PegGameException {
        // Setup
        String expected = "oooo" + "\n" +
        "oo-o" + "\n" +
        "o-oo" + "\n" +
        "oooo" + "\n";

        // Invoke
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        // actual
        assertEquals(expected, board.toString());
    }

    @Test
    public void moveTwiceString() throws PegGameException {
        String expected = "oooo" + "\n" +
        "oooo" + "\n" +
        "o--o" + "\n" +
        "oo-o" + "\n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        board.makeMove(new Move(new Location(3,2), new Location(1,2)));
        System.out.println(board);
        // actual
        assertEquals(expected, board.toString());
    }

    /**
     * Testing for deep copies
     * @throws PegGameException
     */
    @Test
    public void deepCopyTest() throws PegGameException {
        String expected = "oooo" + "\n" +
        "oooo" + "\n" +
        "o--o" + "\n" +
        "oo-o" + "\n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        board.makeMove(new Move(new Location(3,2), new Location(1,2)));
        Board copy = board.deepCopy();

        assertEquals(expected, copy.toString());
    }

    /**
     * Testing to see if making a move on the deep copy also doesn't make a move on the original
     * @throws PegGameException
     */
    @Test
    public void deepCopyMoveTest() throws PegGameException {
        String expected = "ooo-" + "\n" +
                        "oooo" + "\n" +
                        "oooo" + "\n" +
                        "oooo" + "\n";

        String expectedCopy = "oooo" + "\n" +
                            "oooo" + "\n" +
                            "o--o" + "\n" +
                            "oo-o" + "\n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();


        Board copy = board.deepCopy();
        copy.makeMove(new Move(new Location(2,1), new Location(0,3)));
        copy.makeMove(new Move(new Location(3,2), new Location(1,2)));

        assertEquals(expected, board.toString());
        assertEquals(expectedCopy, copy.toString());
        assertNotEquals(expected, expectedCopy);
    }

    /**
     * Testing to see if making a move on the board, then making a deep copy and making another move on the board are different
     * @throws PegGameException
     */
    @Test
    public void deepCopyMoveCopyMoveTest() throws PegGameException {
        String expected = "ooo-" + "\n" +
                        "oooo" + "\n" +
                        "oooo" + "\n" +
                        "oooo" + "\n";

        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        assertEquals(expected, board.toString());

        String expectedCopy = "oooo" + "\n" +
        "oo-o" + "\n" +
        "o-oo" + "\n" +
        "oooo" + "\n";

        Board copy = board.deepCopy();
        copy.makeMove(new Move(new Location(2,1), new Location(0,3)));
        assertEquals(expectedCopy, copy.toString());
        assertNotEquals(board.toString(), copy.toString());

        String expectedMove = "oooo" + "\n" +
                            "oooo" + "\n" +
                            "o--o" + "\n" +
                            "oo-o" + "\n";

        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        board.makeMove(new Move(new Location(3,2), new Location(1,2)));
        assertEquals(expectedMove, board.toString());
        assertNotEquals(board.toString(), copy.toString());
    }

}