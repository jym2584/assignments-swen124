/**
 * A patron class that allows new instances of Patron with name and the optional parameter limit
 * 
 * @author Jin Moon
 */

package assignment2;

import java.util.Arrays;

public class Patron {
    /** Patron class
     * @param name takes in a String name
     * @param limit takes in an optional limit for books, can override defaultRentLimit if necessary
     * @throws IllegalArgumentException throws this error with various conditions:
     *      - There is no book available
     *      - Attempting to rent a book past the rent limit
     *      - If the book can't be found
     *      - 
     */
    public static final int defaultRentLimit = 5; // this can be changed to increase or decrease the limit of allowed books

    private String name;
    private int limit;
    private Book[] books; // array with type Book
    /**
     * Our Patron
     * @param name takes in a name
     * @param limit rent limit
     */
    public Patron(String name, int limit) {
        this.name = name;
        books = new Book[limit];
    }

    /**
     * Our Patron with default parameter defaultRentLimit
     * @param name only takes in a name
     */
    public Patron(String name) {
        this(name, defaultRentLimit);
    }

    /**
     * Checkout method
     * @param book If the book is valid and has an available copy, put the book onto
     *              the patron's list.
     * @throws IllegalArgumentException if there are no copies or the book cannot be found
     */
    public void checkout(Book book) {
        /**Checks out the book given that it doesn't surpass the patron's limit and it is available to take out.
         */
        String message = "  (!) " + book.getTitle() + " by author " + book.getAuthor();
        int i = 0;
        while (i < books.length) {
            if (book.getCopies() == 0) { // if there are no more copies of the books
                System.out.println(message + " cannot be checked out because there is none available.");
                throw new IllegalArgumentException("User tried to check out a book that isn't available.");
            } else if (books[books.length-1] != null) { // if there are no more empty slots and we try to add another book
                System.out.println(message + " cannot be checked out because Patron " + name + " exceeds the allowed borrowed limit (limit: " + books.length + ").");
                throw new IllegalArgumentException("User exceeded the borrow limit.");
            }

            if ( (books[i] == null) && (book.getCopies() > 0) ) { // if there is an empty slot
                books[i] = book; // Adds the book to the Array
                System.out.println(message + " has been checked out.");
                book.checkout(book);
                //System.out.println(book.getAvailability());
                break;
            }
            i++;
        }
    }
    
    /**
     * Return Book method
     * @param book grabs in a book parameter that searches through the patron's
     *              book list. If found, return the book.
     */
    public void returnBook(Book book) {
        /** Returns the book, given that they have it.
         */
        String message = "  (!) " + book.getTitle() + " by author " + book.getAuthor();
        int i = 0;
        while (i <= books.length) { // if the book doesn't exist
            if (i == books.length) { 
                throw new IllegalArgumentException("User tried to return a book that they did not check out or doesn't exist."); // the book cannot be found
            }

            if (book == books[i]) { // if the book exists
                books[i] = null; // Gets rid of the book with a null value on the Array
                System.out.println(message + " has been returned.");
                book.returnDaBook(book);
                //System.out.println(book.getAvailability());
                break;
            }
            i++;
        }
    }

    ////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Patron " + name + " with "+ Arrays.toString(books) +" taken out (limit: " + books.length + ").";
    }    

    public String getName() { return name; }
    public Book[] getBooks() { return books; }

    @Override
    public boolean equals(Object o) {
        /**
         * Duplicate if names are the same
         */
        if (!(o instanceof Patron)) {
            return false;
        }

        Patron other = (Patron)(o);
        return ( name.equals(other.name));
    }

}