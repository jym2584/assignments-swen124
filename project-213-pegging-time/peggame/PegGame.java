package peggame;
import java.util.Collection;
/** Peg game interface */
public interface PegGame{

    /**
     * Gets possible moves from where the peg currently is
     * @return potentially a backtracking algorithm
     */
    public Collection<Move> getPossibleMoves();
    
    /**
     * Gets the current state of the game
     * @return state of the game
     */
    public GameState getGameState();
    
    /**
     * Making a move
     * @param move has to take in from and to locations
     * @throws PegGameException if a move is invalid
     */
    public void makeMove(Move move) throws PegGameException;

    default PegGame deepCopy() {
        throw new UnsupportedOperationException();
    }
    
}