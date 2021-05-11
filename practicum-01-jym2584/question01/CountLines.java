package question01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem Statement
 * We want to be able to determine how many lines in a text file contain
 * at least one occurence of a given word.
 * 
 * Requirements
 * 1. You should only match on whole words in a line.  A word is defined
 *    as a sequence of non-whitespace characters.
 * 
 * 2. For this exercise, if punctuation is immediately adjacent to a word,
 *    the punctuation should be considered part of the word.
 *    Example: If the given word is "dog" and the line is "I have a dog.",
 *    this should NOT count as a match as "dog" does not equal "dog."
 * 
 * 3. Matches between the given word and words in a line should be case
 *    insensitive, e.g. "DoG" matches "dog".
 *    Recall that String.toLowerCase() converts all characters in a string to
 *    lowercase characters.
 * 
 * 4. If a word matches multiple occurrences on a line, you should only
 *    increase your count by one -- you are counting lines in which the word
 *    appears at least once, not the number of times the word appears in the file.
 *    Example: If the given word is "dog" and the line is "My dog has a dog friend.",
 *    your count should only increase by 1.
 * 
 * 5. Any exceptions should be handled by returning -1.  Your program should not
 *    crash.
 * 
 * Part A
 * Complete the stringContainsWord method to determine if a string contains the given
 * word according to the requirements above.
 * 
 * Part B
 * Using the stringContainsWord method from PART A, complete the countLines method to
 * determine how many lines in the file contain at least one occurrence of the given word,
 * according to the requirements above.
 * 
 */
public class CountLines {

    /**
     * Checks to see if a string contains at least one occurrence of the given word
     * 
     * @param aString - string to check
     * @param aWord - word to check for
     * @return - true if string contains at least one occurrence of the given word, false otherwise
     */
    public static boolean stringContainsWord (String aString, String aWord) {
        boolean found = false;
        
        String[] tokens = aString.split(" ");
        for(String word: tokens) {
            if (aWord.equals(word)) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Returns a count of the number of lines that contains at least one occurrence
     * of the given word.
     * @param filename - the filename to read lines from
     * @param word - the word to match against words on a line
     * @return - the count of lines or -1 if any errors with accessing or reading from
     *           the file
     */
    public static int countLines (String filename, String word) {
        int count = 0; 
        String wordLower = word.toLowerCase();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            line = br.readLine();
            while (line != null) {
                line = line.trim();
                String[] splitLine = line.split(" ");

                for (String words: splitLine) {
                    if ( wordLower.equals(words.toLowerCase()) ) {
                        count++;
                    }
                }

                line = br.readLine();
            }

            br.close();
            fr.close();

        return count;

        } catch (IOException ioe) {
            return -1;
        }
    }

    /**
     * The code below is provided as examples and validation.  Note that
     * during grading, additional tests may be run.  You may add additional
     * test cases to the main method.
     */
    public static void runStringContainsWordTest (String aString, String aWord, boolean expected) {
        try {
            boolean actual = stringContainsWord (aString, aWord);
            if (actual == expected) {
                System.out.println ("Test for \"" + aWord + "\" in \"" + aString + "\": PASSED");
                return;
            }
        }
        catch (Exception e) {}

        System.out.println ("Test for \"" + aWord + "\" in \"" + aString + "\": FAILED");
    }

    public static void runCountLinesTest (String filename, String word, int expectedCount) {
        try {
            int actualCount = countLines (filename, word);
            if (actualCount == expectedCount) {
                System.out.println ("Test for \"" + word + "\" in " + filename + ": PASSED");
                return;
            }
        }
        catch (Exception e) {}

        System.out.println ("Test for \"" + word + "\" in " + filename + ": FAILED");
    }

    public static void main (String args[]) {
        runStringContainsWordTest ("I have a green bird.", "dog", false);
        runStringContainsWordTest ("I have a dog.", "dog", false);
        runStringContainsWordTest ("My dog is brown.", "dog", true);
        runStringContainsWordTest ("My dog is dog.", "dog", true);
        runStringContainsWordTest ("My dog has a dog friend.", "dog", true);

        System.out.println();

        countLines("alice.txt", "ELECTRONIC");
        System.out.println(countLines("alice.txt", "ELECTRONIC"));
        runCountLinesTest ("alice.txt", "english", 2);
        runCountLinesTest ("nosuchfile.txt", "word", -1);
        runCountLinesTest ("alice.txt", "nosuchword", 0);
        runCountLinesTest ("alice.txt", "ELECTRONIC", 26);
    }
}
