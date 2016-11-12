package test;

import main.Book;
import main.Series;
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

    @Test(expected=IllegalArgumentException.class)
    public void testBookNotInSeriesThrowsException() {
        new Book("A Sack Of Jam");
    }

    @Test
    public void testKnownBooksInSeries() {
        assertEquals("a game of thrones", Series.GAME_OF_THRONES.getTitle());
        assertEquals("a clash of kings", Series.CLASH_OF_KINGS.getTitle());
        assertEquals("a storm of swords", Series.STORM_OF_SWORDS.getTitle());
        assertEquals("a feast for crows", Series.FEAST_FOR_CROWS.getTitle());
        assertEquals("a dance with dragons", Series.DANCE_WITH_DRAGONS.getTitle());}
}