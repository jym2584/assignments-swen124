package assignment_101;

import java.util.Scanner;

public class SequentialCount {
    private static int count = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int input = scanner.nextInt();

        for(int i = 0; i < input; i++) {
            Thread thread = new Thread( () -> {
                System.out.println(count);
                count++;
            });

            thread.start();
            try { thread.join(); } catch (InterruptedException e) {}
        }
        
        scanner.close();
    }
    
}
