/**
 * JUnit Testing for Book, Patron with 1 book limit and Patron with 3 book limit
 * 
 * @author Jin Moon
 */

package assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CombinedTest {
    /** Our testing function
     */
    @Test
    public void testBook() {
        // Setup
        Book lotr = new Book("Lord of the Rings", "JC Penny", 3);
        Book lotr_2 = new Book("Lord of the Rings", "JC Penny", 2);
        Book aBook = new Book("A Book", "John Doe");

        // Invoking and Analyzing

            // Testing LOTR
            assertEquals("Lord of the Rings", lotr.getTitle());
            assertEquals("JC Penny", lotr.getAuthor());
            assertEquals(3, lotr.getCopies());
            assertEquals("Available", lotr.getAvailability());

            // Testing duplicate books
            // assertEquals(lotr, lotr_2); // This test is redundant because each book is its own memory address. Count doesn't matter anymore
            assertNotEquals(lotr, aBook);
    }
    @Test
    public void testBookCheckout() {
    // Testing checkout and return functions
    Book lotr = new Book("Lord of the Rings", "JC Penny", 3);
    Book lotr_2 = new Book("Lord of the Rings", "JC Penny", 2);
    Book aBook = new Book("A Book", "John Doe");

            // Testing checkout and returning book count
            lotr.checkout(lotr);
            assertEquals(2, lotr.getCopies());
            lotr.returnDaBook(lotr);
            assertEquals(3, lotr.getCopies());
            aBook.checkout(aBook);
            assertEquals("Checked Out", aBook.getAvailability()); // Checking for 0 books on aBook 

    }

    @Test
    public void testPatronLimit1() {
        // Testing patron of 1

        //setup
        Patron aPatron = new Patron("Jane Doe", 1);
        // invoke
        Book lotr = new Book("Lord of the Rings", "JC Penny", 3);
        Book aBook = new Book ("The Book", "She Book", 0);
        
        // analyze
        assertEquals("[null]", Arrays.toString(aPatron.getBooks()));

        // invoke and analyze
            
            // Checking out a book
            aPatron.checkout(lotr);
            assertEquals("[Title: Lord of the Rings by JC Penny (2 Available)]", Arrays.toString(aPatron.getBooks()));
            try { // Checking out a book when they're only allowed to have one.
                aPatron.checkout(lotr); 
            } catch (IllegalArgumentException iae) {                           
                System.out.println("Catched IllegalArgumentException ----------> renting a book that's past their rent limit");
            }     

    }

    @Test
    public void testPatronBookEdgeCases() {
        // Testing edge cases for patron with book functions
        Patron aPatron = new Patron("Jane Doe", 1);
        Book lotr = new Book("Lord of the Rings", "JC Penny", 3);
        Book aBook = new Book("A Book", "John Doe");
        // invoke and analyze
            
            // Checking out a book
            aPatron.checkout(lotr);
            assertEquals("[Title: Lord of the Rings by JC Penny (2 Available)]", Arrays.toString(aPatron.getBooks()));
            try { // Checking out a book when they're only allowed to have one.
                aPatron.checkout(lotr); 
            } catch (IllegalArgumentException iae) {                           
                System.out.println("Catched IllegalArgumentException ----------> renting a book that's past their rent limit");
            }     

            // Catching IllegalArgumentException
            try { // Returning a book when they don't currently have it in their possession
                aPatron.returnBook(aBook); 
            } catch (IllegalArgumentException iae) {
                System.out.println("Catched IllegalArgumentException twice! ---> returning a book that is not in their hand");
            }
            try { // Renting a book that is out of stock
                Book book2 = new Book("The Book", "The best person", 0);
                aPatron.checkout(book2); // Doesn't have the book anymore, should raise IllegalArgumentException
            } catch (IllegalArgumentException iae) {
                System.out.println("Catched IllegalArgumentException thrice! --> renting a book that is out of stock");
            }

    }

    @Test
    public void testPatronLimit3() {
        // setup
        Patron aPatron = new Patron("Jane Doe", 3);
        Patron aPatron2 = new Patron("Jane Doe");
        Patron the_Patron = new Patron("Joe Will Smith");

        Book lotr = new Book("Lord of the Rings", "JC Penny", 3);
        Book aBook = new Book("A Book", "John Doe");

        // invoke and analyze
            
            // Testing aPatron
            assertEquals("Jane Doe", aPatron.getName());
            assertEquals("[null, null, null]", Arrays.toString(aPatron.getBooks())); // empty books

            // Analyzing books before using checkout/return functions
            assertEquals(3, lotr.getCopies());
            assertEquals(1, aBook.getCopies());

            // Testing checkout and returning book count (blended testing)
            aPatron.checkout(lotr);
            assertEquals("[Title: Lord of the Rings by JC Penny (2 Available), null, null]", Arrays.toString(aPatron.getBooks())); // Checking if the availability of the book also reduced
            aPatron.checkout(aBook);
            assertEquals("[Title: Lord of the Rings by JC Penny (2 Available), Title: A Book by John Doe (0 Checked Out), null]", Arrays.toString(aPatron.getBooks())); // Also checking 0 availability for A Book

            aPatron.returnBook(lotr);
            assertEquals("[null, Title: A Book by John Doe (0 Checked Out), null]", Arrays.toString(aPatron.getBooks()));
            aPatron.returnBook(aBook);
            assertEquals("[null, null, null]", Arrays.toString(aPatron.getBooks()));

            // Analyzing if availability of the books are the same when returning them
            assertEquals(3, lotr.getCopies());
            assertEquals(1, aBook.getCopies());

            // Testing Duplicate
            assertEquals(aPatron, aPatron2);
            assertNotEquals(aPatron, the_Patron);

    }

}
