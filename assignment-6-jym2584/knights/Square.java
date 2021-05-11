package knights;
import graphs.*;

/**
 * Square class
 */
public class Square {
    private final int row;
    private final int column;

    /**
     * Square
     * @param row Row position
     * @param column Column position
     */
    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Automatically parses row and column into integers
     * @param row row num
     * @param col column num
     */
    public Square(String row, String col) {
        this(Integer.parseInt(row), Integer.parseInt(col));
    }

    @Override
    public int hashCode() {
        return row * 100 + column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    /**
     * Checks for equality
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Square) {
            Square other = (Square)o;
            return this.row == other.row && this.column == other.column;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "(" + row + ", " + column +")";
    }
}

