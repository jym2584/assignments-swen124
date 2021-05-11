package peggame;

import java.util.Scanner;

import peggame.provided.backtracker.Backtracker;
import peggame.provided.backtracker.Configuration;

import java.io.IOException;

public class Command {
    /**
     * Playing the game given a board
     * @param board board with filled/unfilled holes
     * @throws NumberFormatException if the format is somehow wrong
     * @throws PegGameException if an invalid move was made
     */
    public static void playGame(PegGame board) throws NumberFormatException, PegGameException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(">> "); // Getting input
                String input = scanner.nextLine();
                System.out.println(); // new line

                String[] tokens = input.split(" ");
                
                if (tokens[0].toLowerCase().equals("help")) {
                    /**
                     * Help command
                     */
                    System.out.println("Type:\n" +
                    "  - move <r1> <c1> <r2> <c2> to make a move\n" +
                    "  - hint to get the best possible move\n" + 
                    "  - quit to end the game and terminate\n" +
                    "  - solve to get the list of moves to win the game");
                
                } else if (tokens[0].toLowerCase().equals("move")) {
                    /**
                     * Make a move to the board and check its current game state
                     */
                    board.makeMove(new Move(new Location(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2])), new Location(Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]))));

                    if (board.getGameState() == GameState.STALEMATE) {
                        System.out.println(board);
                        System.out.println("Tough try!");
                        break;
                    }

                    else if (board.getGameState() == GameState.WON) {
                        System.out.println("Congrats!");
                        break;
                    }

                } else if (tokens[0].toLowerCase().equals("hint")) { // Works
                    /**
                     * Getting next move that leads to a winning solution
                     */

                    PegGameSolver config = new PegGameSolver(board);        
                    Backtracker solver = new Backtracker(false);
                    config = (PegGameSolver)solver.solve(config);
                    if (config != null) {
                        if (config.getSolution().get(0) != null) {
                            System.out.println(config.getSolution().get(0));
                        } else { // no hint can be generated that leads to a correct solution
                            System.out.println("You are so terrible not even an algorithm can fix your board. Absolute dog water. So free. Freer than a free sample at Costco. Earnings check? Oh wait you have none.");
                        }
                    } else {
                        System.out.println("You are so terrible not even an algorithm can fix your board. Absolute dog water. So free. Freer than a free sample at Costco. Earnings check? Oh wait you have none.");
                    }
                    
                    
                }
                else if (tokens[0].toLowerCase().equals("quit")) {
                    /**
                     * Breaking the loop
                     */
                    break;
                }
                else if (tokens[0].toLowerCase().equals("solve")) {
                    /*
                    *  Solves board and print out move and board as a move is made
                    */
                    PegGameSolver config = new PegGameSolver(board);        
                    Backtracker solver = new Backtracker(false);
                    Configuration solution = solver.solve(config);

                    if (solution == null) { //if there is no solution and it's impossible to solve, then print this
                        System.out.println("You are so terrible not even an algorithm can fix your board. Absolute dog water. So free. Freer than a free sample at Costco. Earnings check? Oh wait you have none.");
                    } else { //else solve it and print out the move and board everytime a move is made so the player can see what's happening

                        config = (PegGameSolver)solver.solve(config);

                        if (config.getSolution().size() == 2) {
                            System.out.println(config.getSolution().get(0));
                            System.out.println(config.getPegGameStrings().get(0));
                        }
                        else {
                            for(int i = 0; i < config.getSolution().size(); i++) {
                            System.out.println(config.getSolution().get(i));
                            System.out.println(config.getPegGameStrings().get(i));
                            }
                        }
                        
                        System.out.println("Current board:\n" + solution);
                        System.out.println("You won! I think.. in a way?!");
                        break;
                    }

                } else {
                    if (input.equals("")) {
                        input = "No input given";
                    }
                    System.out.println("Invalid input detected for: " + input + ". Type help for a list of valid commands.");
                }

            } catch (PegGameException pge) {
                System.out.println(pge.getMessage() + ". Try again.");
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect parameters used for move (" + nfe.getMessage() + "). \n  - Please use the correct parameters: move <r1> <c1> <r2> <c2> to make a move");
            } catch (ArrayIndexOutOfBoundsException aiobe) {
                System.out.println("Invalid input detected for detecting numerous parameters for the given input.\n  - Please use the correct parameters: move <r1> <c1> <r2> <c2> to make a move");
            }
            System.out.println("Current board:\n" + board);
        }
        System.out.println("See ya!");
        scanner.close();
    }

    // manual testing
    public static void main(String[] args) throws IOException, NumberFormatException, PegGameException {
        PegGame board = File.makeBoard("data/4_4.txt");
        playGame(board);
    }
}