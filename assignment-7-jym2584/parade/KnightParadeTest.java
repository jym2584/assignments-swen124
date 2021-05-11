package parade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import backtracker.Backtracker;
import backtracker.Configuration;

@Testable
public class KnightParadeTest {
    @Test
    public void testN5() {
        String expected = "[  1][ 12][ 17][ 10][ 23]\n" +
        "[ 18][  9][ 22][  5][ 16]\n" +
        "[ 13][  2][ 11][ 24][ 21]\n" +
        "[  8][ 19][  4][ 15][  6]\n" +
        "[  3][ 14][  7][ 20][ 25]\n";

        Chessboard board = new Chessboard(5);
        KnightParade config = new KnightParade(0, 0, board);
        Backtracker solver = new Backtracker(false);
        Configuration solution = solver.solve(config);
        String actual = solution.toString();

        assertEquals(expected, actual);
    }
    @Test
    public void testN6() {
        String expected = "[  1][ 12][ 35][ 32][ 25][ 14]\n" +
        "[ 36][ 31][ 26][ 13][  8][ 33]\n" +
        "[ 11][  2][  9][ 34][ 15][ 24]\n" +
        "[ 30][ 27][ 22][  5][ 18][  7]\n" +
        "[  3][ 10][ 29][ 20][ 23][ 16]\n" +
        "[ 28][ 21][  4][ 17][  6][ 19]\n";

        Chessboard board = new Chessboard(6);
        KnightParade config = new KnightParade(0, 0, board);
        Backtracker solver = new Backtracker(false);
        Configuration solution = solver.solve(config);
        String actual = solution.toString();

        assertEquals(expected, actual);
    }
}