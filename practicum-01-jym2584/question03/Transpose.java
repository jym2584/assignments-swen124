package question03;

import java.util.Arrays;

/**
 * Complete the method below to transpose a 2D array, that is rotate the
 * rows and columns.
 * 
 * Given an input 2D array of size R x C, return an output 2D array of size C x R,
 * where output col 1 has the same values as input row 1, output col 2 has the
 * same values as input row 2, etc
 * 
 * Example:
 * Input[3][4] =
 * [[1,  2,  3,  4],
 *  [5,  6,  7,  8],
 *  [9, 10, 11, 12]]
 * 
 * Output[4][3] =
 * [[1, 5, 9]
 *  [2, 6, 10]
 *  [3, 7, 11]
 *  [4, 8, 12]]
 * 
 * You can assume that all of the rows of the input 2D array have the same number of
 * columns, e.g. it is not ragged.
 */
public class Transpose {
    /**
     * Transposes a 2D array by rotating the rows and columns
     * @param input - 2D array - all rows have the same number of columns
     * @return - transposed 2D array
     */
    public static int[][] transpose(int[][] input) {
        int row = input.length; // 3
        int column = input[0].length; // 4
        int[][] transposed = new int[column][row];

        int count = 1;

        for (int rowNum = 0; rowNum < row; rowNum++) {
            for (int col = 0; col < column; col++) {
                transposed[col][rowNum] = count;
                count++;
            }
        }
        return transposed;
    }

    /**
     * The code below is provided as examples and validation.  Note that
     * during grading, additional tests may be run.  You may add additional
     * test cases to the main method.
     */
    public static void runTest(int testNum,int[][] input,int[][] expectedOutput) {
        try {
            int[][] actualOutput = transpose(input);

            for (int r = 0;r < expectedOutput.length;++r) {
                if (Arrays.equals(expectedOutput[r],actualOutput[r]) == false) {
                    System.out.println("Test " + testNum + ": FAILED");
                    return;
                }
            }
            System.out.println("Test " + testNum + ": Passed");
            return;
        }
        catch (Exception e) {}

        System.out.println("Test " + testNum + ": FAILED");
    }

    public static void main(String[] args) {


        int[][] input = new int[][]{{1,  2,  3,  4},
                                    {5,  6,  7,  8},
                                    {9, 10, 11, 12}};

        int[][] expectedOutput = new int[][]{{1, 5,  9},
                                             {2, 6, 10},
                                             {3, 7, 11},
                                             {4, 8, 12}};

        runTest(1,input,expectedOutput);
        int[][] transposed = transpose(input);
        for (int[] row: transposed) {
            System.out.println(Arrays.toString(row));
        }
        /**
         * Example 2
         */
        input = new int[][] {{1},
                             {2}};
        
        expectedOutput = new int[][] {{1,2}};
        runTest(2,input,expectedOutput);

        /**
         * Example 3
         */
        input = new int[][] {{1,2},
                             {3,4}};
        expectedOutput = new int[][] {{1,3},
                                        {2,4}};
        runTest(3,input,expectedOutput);

        /**
         * Example 4
         */
        input = new int[][] {{1}};
        expectedOutput = new int[][] {{1}};
        runTest(4,input,expectedOutput);
    }
    
}
