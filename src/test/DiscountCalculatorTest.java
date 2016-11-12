package test;

import main.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Tests the DiscountCalculator class
 */
public class DiscountCalculatorTest {

    @Test
    public void testCreateDiscount() {
        Basket basket = new Basket();
        DiscountCalculator discApplier = new DiscountCalculator(basket);
        assertEquals(0, discApplier.getTotalDiscounts(), 0);
    }

    @Test
    public void testKnownDiscounts() {
        assertEquals(0, Discount.ONE_BOOK.getPercentage(), 0);
        assertEquals(5, Discount.TWO_BOOKS.getPercentage(), 0);
        assertEquals(10, Discount.THREE_BOOKS.getPercentage(), 0);
        assertEquals(20, Discount.FOUR_BOOKS.getPercentage(), 0);
        assertEquals(25, Discount.FIVE_BOOKS.getPercentage(), 0);
    }

    @Test
    public void testBookOccurrenceFrequency() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("A Game Of Thrones"));
        books.add(new Book("A Clash Of Kings"));
        books.add(new Book("A Clash Of Kings"));
        books.add(new Book("A Dance With Dragons"));
        books.add(new Book("A Dance With Dragons"));
        books.add(new Book("A Dance With Dragons"));
        // convert all to string representations
        List<String> bookStrings = new ArrayList<>();
        for (Book book : books) { bookStrings.add(book.getTitle()); }
        assertEquals(1, Collections.frequency(bookStrings, "A Game Of Thrones"));
        assertEquals(2, Collections.frequency(bookStrings, "A Clash Of Kings"));
        assertEquals(3, Collections.frequency(bookStrings, "A Dance With Dragons"));
    }

    @Test
    public void testBookOccurrenceFrequencyMutableInt() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("A Game Of Thrones"));
        books.add(new Book("A Clash Of Kings"));
        books.add(new Book("A Clash Of Kings"));
        books.add(new Book("A Dance With Dragons"));
        books.add(new Book("A Dance With Dragons"));
        books.add(new Book("A Dance With Dragons"));
        Map<String, MutableInt> bookCounts = new HashMap<>();
        for (Book book : books) {
            if (!bookCounts.containsKey(book.getTitle())) {
                bookCounts.put(book.getTitle(), new MutableInt());
            } else {
                bookCounts.get(book.getTitle()).increment();
            }
        }
        assertEquals(1, bookCounts.get("A Game Of Thrones").get());
        assertEquals(2, bookCounts.get("A Clash Of Kings").get());
        assertEquals(3, bookCounts.get("A Dance With Dragons").get());
    }

    @Test
    public void testSeriesTotalAfterDiscount() {
        assertEquals(0, DiscountCalculator.getSeriesDiscount(1), 0);
        assertEquals(0.8, DiscountCalculator.getSeriesDiscount(2), 0);
        assertEquals(2.4, DiscountCalculator.getSeriesDiscount(3), 0);
        assertEquals(6.4, DiscountCalculator.getSeriesDiscount(4), 0);
        assertEquals(10, DiscountCalculator.getSeriesDiscount(5), 0);
    }
}