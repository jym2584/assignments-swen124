package peggame;

import java.io.IOException;
import java.util.Scanner;
public class Project3Main {

    /**
     * Main program to run the peg game
     * @param args
     * @throws IOException thrown if an invalid filename is given
     * @throws NumberFormatException
     * @throws PegGameException 
     */
    public static void main(String[] args) throws IOException, NumberFormatException, PegGameException{
        boolean noQuit = true;
        String input = "";
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        input = scanner.nextLine();
        try{
            PegGame board = TriangleFile.makeBoard(input);
            System.out.println(board);

            while(noQuit) { // while the input isn't valid
                try {
                    Command.playGame(board);
                    noQuit = false;

                } catch (ArrayIndexOutOfBoundsException aiobe) {
                    System.out.println("Invalid input. Try again or type help for a list of commands.");
                } 
            }
            
            scanner.close();

        } catch (IOException pge) {
            System.out.println(input + " is an invalid filename. Exiting program.");
        }
    }
}