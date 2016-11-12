package test;

import main.Basket;
import main.Book;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Basket class
 */
public class BasketTest {

    @Test
    public void testCreateBasket() {
        Basket basket = new Basket();
        assertEquals(0, basket.getItems().size());
        assertEquals(0.0, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testAddOneBook() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        assertEquals(1, basket.getItems().size());
        assertEquals(8.0, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testAddTwoIdenticalBooks() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        basket.addItem(new Book("A Storm Of Swords"));
        assertEquals(2, basket.getItems().size());
        assertEquals(16.0, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testAddTwoDifferentBooks() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        basket.addItem(new Book("A Feast For Crows"));
        assertEquals(2, basket.getItems().size());
        // 5% discount for 2 different books
        assertEquals(15.20, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testAddThreeDifferentBooks() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        basket.addItem(new Book("A Feast For Crows"));
        basket.addItem(new Book("A Game Of Thrones"));
        assertEquals(3, basket.getItems().size());
        // 10% discount for 3 different books
        assertEquals(21.60, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testAddFourDifferentBooks() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        basket.addItem(new Book("A Feast For Crows"));
        basket.addItem(new Book("A Game Of Thrones"));
        basket.addItem(new Book("A Clash Of Kings"));
        assertEquals(4, basket.getItems().size());
        // 20% discount for 4 different books
        assertEquals(25.60, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testAddFiveDifferentBooks() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        basket.addItem(new Book("A Feast For Crows"));
        basket.addItem(new Book("A Game Of Thrones"));
        basket.addItem(new Book("A Clash Of Kings"));
        basket.addItem(new Book("A Dance With Dragons"));
        assertEquals(5, basket.getItems().size());
        // 25% discount for 5 different books
        assertEquals(30, basket.getTotalAfterDiscounts(), 0);
    }

    @Test
    public void testFiveBookSeriesAndOneBook() {
        Basket basket = new Basket();
        basket.addItem(new Book("A Storm Of Swords"));
        basket.addItem(new Book("A Feast For Crows"));
        basket.addItem(new Book("A Game Of Thrones"));
        basket.addItem(new Book("A Clash Of Kings"));
        basket.addItem(new Book("A Dance With Dragons"));
        basket.addItem(new Book("A Storm Of Swords"));
        assertEquals(6, basket.getItems().size());
        // 25% discount applied to 5 book series, no discount for 1 book
        assertEquals(38, basket.getTotalAfterDiscounts(), 0);
    }
}