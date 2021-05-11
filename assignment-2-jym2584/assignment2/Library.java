package assignment2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Library {
    private static final int patronLimit = 50;
    private Patron[] patrons;
    private Book[] catalog;

    /** Our Library
     * @param patrons patrons with default limit patronLimit
     * @param catalog our empty array of books, will populate with populateBooks function
     */
    public Library() {
        patrons = new Patron[patronLimit];
        catalog = new Book[0];
    }

    public String getPatrons() {
        return Arrays.toString(patrons);
    }

    /**
     * getBooks accessor that prints a list of books
     */
    public void getBooks() {
        int i = 1;
        for (Book book : catalog) {
            System.out.println(book + " Line: " + i);
            i++;
        }
        //return Arrays.toString(catalog);
    }

    /**
     * Populate books method that adds each book to the book array given a file
     * @param filename takes in a filename then populates the array with the size on the file 
     * @throws IOException if the file cannot be read
     */
    public void populateBooks(String filename) throws IOException {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int bookLimit = Integer.parseInt(line);
            
            catalog = new Book[bookLimit];
            line = br.readLine();

            for (int i = 0; line != null; i++) {
                line = line.trim();
                String[] tokens = line.split(",");

                if (tokens.length == 3) {
                    catalog[i] = new Book(tokens[0] + "," + tokens[1], tokens[2]);
                    //System.out.println(Arrays.toString(tokens) + " Length " + tokens.length);

                } else if (tokens.length == 2) {
                    //System.out.println(Arrays.toString(tokens) + " Length " + tokens.length);
                    catalog[i] = new Book("\"" + tokens[0] + "\"", tokens[1]);
                } else {
                    catalog[i] = null; // Can assume everything else is an invalid book
                }

                line = br.readLine();
            }


        } catch (IOException ioe) {
            System.out.println("Cannot read the file.");
        }
    }

    /**
     * Checkout Method
     * @param patron takes in a patron name, checks if they exist and checkout the book. Creates a new
     *               patron otherwise (and also checks out the book)
     * @param book takes in a book name, checks if it exists first before checking for the patron name
     */
    public void checkout(String patron, String book) {
        //System.out.println(book);
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i].getTitle().equals(book) && catalog[i].getAvailability().equals("Available")) { // Found the book
                //System.out.println("> Found the book at catalog index " + i);

                for (int j = 0; j < patrons.length; j++) {
                    if (patrons[j] == null) { // Let's add our new patron f there's an empty slot available
                        patrons[j] = new Patron(patron);
                        System.out.println("  (!) Patron " + patrons[j].getName() + " is now added to our patrons!");
                        patrons[j].checkout(catalog[i]); // Also checks if the Patron exceeds the borrow limit, or if the book is checked out
                        return;
                    } else if (patrons[j].getName().equals(patron)) { // Found our patron
                        //System.out.println("> Found " + patrons[j].getName() + "!");
                        boolean isDuplicate = findDuplicate(patrons[j], catalog[i]);  
                        if (isDuplicate) { // Finds if the user already owns the book
                            System.out.println("  (!) " + patrons[j].getName() + " has already checked out " + catalog[i].getTitle() + " by " + catalog[i].getAuthor());
                            return;
                        } else {
                            patrons[j].checkout(catalog[i]); // Also checks if the Patron exceeds the borrow limit, or if the book is checked out
                            return;
                        }
                    } 
                }
            }
        }
        System.out.println("  (!) The book " + book + " doesn't seem to exist in our catalog.");
    }
 
    /**
     * Finds any duplicate instances of the book, only given their name
     * Compares with the book the patron has and the catalog
     * @param patron grabs the patron's book list
     * @param book grabs the book name in question and compares it with the catalog
     * @return true if a duplicate has been found, false otherwise
     */
    public boolean findDuplicate(Patron patron, Book book) {
        for (int i = 0; i < patron.getBooks().length; i++) {
            if (i == patron.getBooks().length) {
                return false;
            }
            if (patron.getBooks()[i].getTitle() != null) {
                if (patron.getBooks()[i].getTitle().equals(book.getTitle())) {
                    return true;
                }
            }
        }
        return false;
        
    }

    /**
     * Removes the book from the patron's list
     * @param patron finds the patron
     * @param book if the patron is valid, grab the memory address of that book and compare it with the catalog
     *              if the same memory address is found, make that book available
     */
    public void returnToCatalog(String patron, String book) {
        //System.out.println(Arrays.toString(patrons));
        for (int j = 0; j < patrons.length; j++) { // Searching the patrons
            if (patrons[j] == null) { // If we can't find our patron in the available list
                //patrons[j] = new Patron(patron);
                System.out.println(">  (!) The patron " + patron + " doesn't seem to exist.");
                //patrons[j].checkout(catalog[i]); // Also checks if the Patron exceeds the borrow limit, or if the book is checked out
                return;
            } else if (patrons[j].getName().equals(patron)) {
                //System.out.println("> Found " + patrons[j].getName() + "!");
                for (int i = 0; i < patrons[j].getBooks().length; i++) { // Searching the patron's list for the book name
                    try {
                        if (patrons[j].getBooks()[i].getTitle().equals(book)) { // Grabbing the memory address of the book
                            //System.out.println("Found the memory address of the book");
                            for (int k = 0; k < catalog.length; k++) { // Now searching for the catalog to find the memory address of that book
                                if(patrons[j].getBooks()[i] == catalog[k]) { // Finding memory address of the book in the catalog
                                    //System.out.println("Found book at catalog " + k);
                                    patrons[j].returnBook(patrons[j].getBooks()[i]); // Also checks if the Patron exceeds the borrow limit, or if the book is checked out
                                    return;

                                }
                            }
                        }
                    } catch (NullPointerException npe) { } // If the book doesn't exist on the Patron, will catch invalid book for line 156
                }
                System.out.println("  (!) The book " + book + " doesn't seem to exist in " + patrons[j].getName() + "'s checked out list.");
                return;
            }
        }
    }
    
    @Override
    public String toString() {
        return "A Library with " + patrons.length + " patrons and a catalog of " + catalog.length + " books.";
    }

    /**
     * Our main library function
     * @param args
     */
    public static void main(String[] args) {
        try {
            // Initializing the library
            Library myLibrary = new Library();
            myLibrary.populateBooks("data/book_list.txt");

            // Welcome Message
            System.out.println("Welcome to the Library, what would you like to do?" 
             + "\n - To checkout a book, enter: c \"Patron Name\" \"Book Name\""
             + "\n - To return a book, enter: c \"Patron Name\" \"Book Name\"");

            boolean noQuit = false;

            while (noQuit == false) {
                // Initializing the Scanner
                Scanner scanner = new Scanner(System.in);
                System.out.print("> ");
                String input = scanner.nextLine();
                String[] tokens = input.trim().split(" \"");
                //System.out.println(Arrays.toString(tokens) + " Length:" + tokens.length);
                
                // Commands
                if (tokens[0].equals("bye")) {
                    noQuit = true;
                    scanner.close();
                    System.out.println("Goodbye!");
                    return;
                } else if (tokens.length > 1) { // Library searching
                    if (tokens[0].equals("c")) {
                        //System.out.println("\"" + tokens[1] + "\"" + tokens[2]);
                        myLibrary.checkout("\"" + tokens[1], "\"" + tokens[2]);
                
                    } else if (tokens[0].equals("r")) {
                        myLibrary.returnToCatalog("\"" + tokens[1], "\"" + tokens[2]);
                        
                    } else {
                        System.out.println("That doesn't seem to be a valid command."
                        + "\n - To checkout a book, enter: c \"Patron Name\" \"Book Name\""
                        + "\n - To return a book, enter: c \"Patron Name\" \"Book Name\"");             
                    }
                } else {
                    System.out.println("That doesn't seem to be a valid command."
                    + "\n - To checkout a book, enter: c \"Patron Name\" \"Book Name\""
                    + "\n - To return a book, enter: c \"Patron Name\" \"Book Name\"");             
                }
            }

        } catch (IOException ioe) {}
    }
}