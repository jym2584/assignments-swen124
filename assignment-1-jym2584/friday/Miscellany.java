import java.util.Arrays;

public class Miscellany {
    public static int[] squares(int n) {
        int[] squared = new int[n];
        for (int i = 0; i < n; i = i + 1) {
            squared[i] = i * i;
        }
    
        return squared;
    }

    public static int[][] multiplcationTable(int rows, int columns) {
        int[][] table = new int [rows][columns];
        for (int row = 0; row < rows; row += 1) {
            for (int column = 0; column < columns; column += 1) {
                table[row][column] = (row + 1) * (column + 1);
            }
        }

        return table;
    }
    public static void main(String[] args) {
        int[] squared = squares(10);
        System.out.println(Arrays.toString(squared));

        int[][] table = multiplcationTable(5, 5);
        for (int i = 0; i < table.length; i += 1) {
            System.out.println(Arrays.toString(table[i]));
        }
    }
}
