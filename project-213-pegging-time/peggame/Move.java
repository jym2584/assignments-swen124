package peggame;

public class Move {
    private Location from;
    private Location to;

    /**
     * Moves a piece to a location
     * @param from starting location
     * @param to ending location
     */
    public Move(Location from, Location to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Getting the starting location
     * @return starting location
     */
    public Location getFrom() {
        return from;
    }

    /**
     * Getting the ending location
     * @return ending location
     */
    public Location getTo() {
        return to;
    }
    
    /**
     * toString for moving the piece
     *      toString: "Moved from (3,2) to (4,3)"
     */
    @Override
    public String toString() {
        String str = "Move {"+from+ ", to " + to + "}";
        return str;
    }

    /**
     * Prevents the same move from being created
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Move) {
            Move o = (Move)obj;
            return (this.to.equals(o.to) && this.from.equals(o.from));
        }
        return false;
    }

    public static void main(String[] args) {
        Move aMove = new Move(new Location(3,2), new Location(4,3));
        Move bMove = new Move(new Location(3,2), new Location(4,3));
        System.out.println(aMove);
        System.out.println(bMove);
        System.out.println(aMove.equals(bMove));
        System.out.println(aMove.toString().equals(bMove.toString()));
    }
}
