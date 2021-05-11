package peggame;
    /**
     * Custom exception for our peg game
     */
public class PegGameException extends Exception {
    private static final long serialVersionUID = 1L;
    /**
     * Custom exception for our peg game
     * @param message custom error message
     */
    public PegGameException(String message) {
        super(message);
    }

}
