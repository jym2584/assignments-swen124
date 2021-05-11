package unrelated;

import java.util.Arrays;

public class InsertAndShift {
    
    public static int[] insert(int num, int[] array) {
        System.out.println(String.format("Array before %s", Arrays.toString(array)));
        
        
        for(int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }

        array[array.length-1] = num;



        System.out.println(String.format("Array after %s", Arrays.toString(array)));
        System.out.println();
        return array;
    }
    
    public static void main(String[] args) {
        int[] array = {12, 13, 14, 15, 16};

        int[] array_after = insert(10, array);
        int[] array_again = insert(20, array_after);
    }
}
