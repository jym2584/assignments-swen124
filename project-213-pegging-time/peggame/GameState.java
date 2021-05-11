package peggame;
/**
 * Enumerations representing the state of the game, printing out its toString when called
 */
public enum GameState {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    STALEMATE("Stalemate"),
    WON("Won");

    private String state;

    /**
     * Using game states as a string
     * @param state 
     */
    private GameState (String state) {
        this.state = state;
    }

    /**
     * Prints the game state as a string
     */
    @Override
    public String toString() {
        return state;
    }

}
