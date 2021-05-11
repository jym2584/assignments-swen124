package parade;

public class Knight {
    private final int row;
    private final int column;

    public Knight (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean canAttack(Knight enemy) {
        if (row == enemy.row || column == enemy.column) {
            return true;
        }
        int[] moves_row = { 2, 2, -2, -2, 1, 1, -1, -1 };
        int[] moves_col = { -1, 1, 1, -1, 2, -2, 2, -2 };        
        for(int i = 0; i < moves_row.length; i++) {
            if ((row + moves_row[i] == enemy.getRow()) && (column + moves_col[i] == enemy.getColumn())) {
                return true;
            }
        }

        return false;
    }

    public int getRow(){ return row; }
    public int getColumn() { return column; }

    @Override
    public String toString() {
        return "Knight(" + row + ", " + column + ")";
    }
}
