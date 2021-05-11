package peggame.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import peggame.*;

/**
 * Testing possiblemoves method from board
 */
@Testable
public class PossibleMovesTest {
    /**
     * Testing a possible move
     */
    @Test
    public void testPossibleMoves() {
        String expected = "[Move {(0,1), to (0,3)}, Move {(0,5), to (0,3)}, Move {(2,1), to (0,3)}, Move {(2,3), to (0,3)}, Move {(2,5), to (0,3)}]";
        List<Location> holes = new ArrayList<>();
        holes.add(new Location(0, 3));
        Board board = new Board(10, 10, holes);
        board.initializeBoard();
        System.out.println(board.getPossibleMoves());
        assertEquals(expected, board.getPossibleMoves().toString());
    }

    /**
     * Testing edge case for no possible moves
     */
    @Test
    public void testPossibleMovesNone() {
        String expected = "[]";
        List<Location> holes = new ArrayList<>();
        Board board = new Board(1, 4, holes);
        board.initializeBoard();

        assertEquals(expected, board.getPossibleMoves().toString());
    }
}
