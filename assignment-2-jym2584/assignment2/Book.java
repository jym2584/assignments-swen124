/**
 * A book class that allows new instances of Book with title, author and the optional parameter numCopies
 * 
 * @author Jin Moon
 */

package assignment2;

public class Book {
    /** Book class
     * @param title takes in the title
     * @param author takes in the author
     * @param copies optional parameter if there is more than 1 instance of the book
     */
    private String title;
    private String author;
    private int copies;
    private CheckedOut status;

    public Book(String title, String name, int numCopies) {
        this.title = title;
        author = name;
        copies = numCopies;
        this.status = CheckedOut.AVAILABLE; // available by default
    }

    public Book(String title, String author) {
        this(title, author, 1);
    }

    public void checkout(Book book) {
        book.copies -= 1;
        updateStatus(book);
    }

    public void returnDaBook(Book book) {
        book.copies++;
        updateStatus(book);
    }

    public void updateStatus(Book book) {
        /** Always updates the status of the book whenever it is checked out or returned 
        */
        if (copies <= 0) {
            this.status = CheckedOut.CHECKED_OUT; 
        } else {
            this.status = CheckedOut.AVAILABLE;
        }        
    }

    @Override
    public String toString() {
        return "Title: " + title + " by " + author + " (" + copies + " " + status + ")";
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCopies() { return copies; }
    public String getAvailability() { return status.toString(); }


}