package queens;

public class Queen {
    private final int row;
    private final int column;

    public Queen (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow(){ return row; }
    public int getColumn() { return column; }
    public boolean canAttack(Queen enemy) {
        if (row== enemy.row || column == enemy.column) {
            return true;
        }

        // Check Diagonals
        int delta_row = Math.abs(row - enemy.row);
        int delta_col = Math.abs(column - enemy.column);
        
        if ( delta_row == delta_col ) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Queen(" + row + ", " + column + ")";
    }

    public static void main(String[] args) {
        Queen a = new Queen(2, 2);
        Queen b = new Queen(0, 4);
        Queen c = new Queen(0, 1);

        System.out.println(a.canAttack(b));
        System.out.println(a.canAttack(c));
        System.out.println(b.canAttack(c));
    }
}
