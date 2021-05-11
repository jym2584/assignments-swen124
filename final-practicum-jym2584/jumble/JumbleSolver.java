package jumble;

import backtracker.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

public class JumbleSolver implements Configuration{
    private static Set<String> allWords;
    private String currentString;
    private String remainingString;

    public JumbleSolver(String currentString, String remainingString){
        this.currentString = currentString;
        this.remainingString = remainingString;
    }

    /**
     * Create a deep copy
     * @param original
     */
    public JumbleSolver(JumbleSolver original) {
        this.currentString = original.currentString;
        this.remainingString = original.remainingString;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();
        
        while(remainingString.length() != 0) {
            JumbleSolver copy = new JumbleSolver(this);
            char getRandomString = remainingString.charAt(new Random().nextInt(remainingString.length() - 1)); // get random string
            copy.currentString += getRandomString;
            String replaceWith = copy.remainingString.replace("" + getRandomString, ""); // remove the character from the string
            copy.remainingString = replaceWith;

            successors.add(copy);
        }

        return successors;
    }

    @Override
    public boolean isValid() {
        return remainingString.length() != 0;
    }

    @Override
    public boolean isGoal() {
        // sees if the current string is in the file and there are no chars left
        return allWords.contains(currentString) && remainingString.length() == 0;
    }

    @Override
    public String toString() {
        return currentString;
    }

    public static void loadWords(String fileName){
        allWords = new HashSet<String>();
        try {
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNext()){
                String line = file.nextLine();
                for (String word : line.split(" ")){
                    if (word.length() <= 7 && word.matches("[a-z]+")) {
                        allWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("***** Word File Not Found ... Did you fix your path?  *****");
        }
    }

    public static void main(String[] args){

        // *****************************************************
        // ***** MODIFY THE PATH BELOW FOR YOUR ENVIRONMENT ****
        // *****************************************************
        loadWords("jumble/words.txt");

        String[] jumbles = new String[] {
            "zzz",
            "unf", 
            "wlyasa", 
            "rshtea", 
            "blscu",
            "dmersia",
            "seay",
            "foobar"  
        };

        Backtracker backtracker = new Backtracker(false);
        for (String jumble : jumbles){
            Configuration initconfig = new JumbleSolver("", jumble); 
            Configuration goal = backtracker.solve(initconfig);
            if(goal == null){
                System.out.println("No solution found for jumble: " + jumble);
            }
            else{
                System.out.println(jumble + " solution is: " + goal);
            }    
        }


    }
}
