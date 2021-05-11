package peggame.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import peggame.*;

@Testable
public class MoveTest {

    @Test
    public void testIsValid() {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(10, 10, holes);
        board.initializeBoard();
        Move move = new Move(new Location(0, 3), new Location(6, 7));
        assertTrue(board.isValid(move));
    }

    @Test
    public void testDiagonal() throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        assertEquals(board.getBoard()[0][3], new Location(0, 3));
        assertEquals(board.getBoard()[2][1], null);
        assertEquals(board.getBoard()[1][2], null);
    }
    @Test
    public void testVertical() throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(2, 3));
        Board board = new Board(4, 4,  holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2,1), new Location(2,3)));
        assertEquals(board.getBoard()[2][3], new Location(2, 3));
        assertEquals(board.getBoard()[2][1], null);
        assertEquals(board.getBoard()[2][2], null);
    }
    @Test
    public void testHorizontal() throws PegGameException {
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 1));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        board.makeMove(new Move(new Location(2,1), new Location(0,1)));
        assertEquals(board.getBoard()[0][1], new Location(0, 1));
        assertEquals(board.getBoard()[2][1], null);
        assertEquals(board.getBoard()[1][1], null);
    }

}