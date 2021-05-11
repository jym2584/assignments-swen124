/**
 * An enumeration class that assigns variables if a book is checked out or not
 * 
 * @author Jin Moon
 */

package assignment2;

public enum CheckedOut {
    CHECKED_OUT("Checked Out"),
    AVAILABLE("Available");

    private String status;

    private CheckedOut (String theStatus) {
        this.status = theStatus;
    }
    
    @Override
    public String toString() {
        return status;
    }

}
