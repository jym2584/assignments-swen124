package peggame;

import java.util.Arrays;

/**
 * Class for creating a row and column location on the game board
 */
public class Location {
    private int row;
    private int col;

    /** Creates a location on the board
     * @param row x position
     * @param col y position
     */
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Gets the x position of the location
     */
    public int getCol() {
        return col;
    }

    /**
     * Gets the y position of the location
     */
    public int getRow() {
        return row;
    }
    /**
     * Gets the x and y coordinate of a location via array
     */
    public int[] getLocation() {
        return new int[] {row, col};
    }

    /**
     * Prevents 2 locations from being created at the same coordinates
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location o = (Location)obj;
            return this.row == o.row && this.col == o.col;
        }
        return false;
    }

    /**
     * Prevents 2 locations from being created at the same coordinates
     */
    @Override
    public int hashCode() {
        return row*17+col*34;
    }

    /**
     * toString representation of the location
     * Prints out: (row, col)
     */
    @Override
    public String toString() {
        String str = "(" + row + "," + col + ")";
        return str;
    }

    public static void main(String[] args) {
        Location fourTwo = new Location(4, 2);
        System.out.println(Arrays.toString(fourTwo.getLocation()));
    }
}
