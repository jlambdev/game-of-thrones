package test;

import main.Book;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Book class
 */
public class BookTest {

    @Test
    public void testCreateBook() {
        Book book = new Book("A Game Of Thrones");
        assertEquals("A Game Of Thrones", book.getTitle());
        assertEquals(8.0, book.getPrice(), 0);
    }
}