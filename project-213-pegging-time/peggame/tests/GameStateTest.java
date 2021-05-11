package peggame.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import peggame.*;
import java.util.*;

/**
 * Test file for enumerations toString and game states
 */

@Testable
public class GameStateTest {
    /**
     * Testing enumerations toString
     */
    @Test
    public void toStringTest() {
        assertEquals("Not Started", GameState.NOT_STARTED.toString());
        assertEquals("In Progress", GameState.IN_PROGRESS.toString());
        assertEquals("Stalemate", GameState.STALEMATE.toString());
        assertEquals("Won", GameState.WON.toString());
    }

    /**
     * If a move hasn't been made
     * @throws PegGameException
     */
    @Test
    public void notStartedTest() throws PegGameException {
        List<Location> holes = new ArrayList<>();
            holes.add(new Location(0, 3));

        Board board = new Board(4, 4, holes);
        board.initializeBoard();
        board.getGameState();

        assertEquals(GameState.NOT_STARTED, board.getGameState());
    }

    /**
     * If a move has been made now
     * @throws PegGameException
     */
    @Test
    public void inProgressTest() throws PegGameException {
        List<Location> holes = new ArrayList<>();
            holes.add(new Location(0, 3));
        Board board = new Board(4, 4, holes);
        board.initializeBoard();

        board.makeMove(new Move(new Location(2,1), new Location(0,3)));
        board.makeMove(new Move(new Location(3,2), new Location(1,2)));
        board.getGameState();

        assertEquals(GameState.IN_PROGRESS, board.getGameState());
    }

    /**
     * Testing win condition if there is at least 1 or more hole
     * @throws PegGameException
     */
    @Test
    public void wonTest() throws PegGameException {
        List<Location> holes = new ArrayList<>();
            holes.add(new Location(0, 1));

        Board board = new Board(1, 4, holes);
        board.initializeBoard();

        board.makeMove(new Move(new Location(0,3), new Location(0,1)));
        board.makeMove(new Move(new Location(0,0), new Location(0,2)));
        board.getGameState();

        assertEquals(GameState.WON, board.getGameState());
    }

    /**
     * Stalemate occurs if there are no moves to be made (no holes)
     * @throws PegGameException
     */
    @Test
    public void StalemateTest() throws PegGameException {
        List<Location> holes = new ArrayList<>();

        Board board = new Board(1, 4, holes);
        board.initializeBoard();

        board.getGameState();

        assertEquals(GameState.STALEMATE, board.getGameState());
    }
    
}
