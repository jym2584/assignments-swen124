package assignment_132;

import java.util.*;
import assignment_132.Hangman.Status;
import backtracker.*;

public class HangmanSolver implements Configuration {
    private Hangman original;
    public HangmanSolver(Hangman original) {
        this.original = original;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        for(char i = 'A'; i <= 'Z'; i++) {
            Hangman copy = new Hangman(original); // make copy of hangman
            boolean makeMove = copy.guess(i); // make move on copy

            if(makeMove) { // if the move was made
                successors.add(new HangmanSolver(copy)); // add possible move to successors
            }
        }

        return successors;
        
    }

    @Override
    public boolean isValid() {
        return !original.getStatus().equals(Status.LOST);
    }

    @Override
    public boolean isGoal() {
        return original.getStatus().equals(Status.WON);
    }

    @Override
    public String toString() {
        return String.format("Guesses: %s %n%s", original.getGuesses(), original.revealed());
    }


    public static void main(String[] args) {
        Hangman hangman = new Hangman("Humpty Dumpty sat on a wall.");
        HangmanSolver config = new HangmanSolver(hangman);
        Backtracker solver = new Backtracker(false);
        Configuration solution = solver.solve(config);
        if(solution == null) {
            System.out.println("No solution");
        } else {
            System.out.println(solution);
        }
    }
    
}
