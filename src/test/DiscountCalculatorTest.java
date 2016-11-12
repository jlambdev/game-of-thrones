package test;

import main.Basket;
import main.Discount;
import main.DiscountCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the DiscountCalculator class
 */
public class DiscountCalculatorTest {

    @Test
    public void testCreateDiscount() {
        Basket basket = new Basket();
        DiscountCalculator discApplier = new DiscountCalculator(basket);
        assertEquals(0, discApplier.getDiscount(), 0);
    }

    @Test
    public void testKnownDiscounts() {
        assertEquals(0, Discount.ONE_BOOK.getPercentage(), 0);
        assertEquals(5, Discount.TWO_BOOKS.getPercentage(), 0);
        assertEquals(10, Discount.THREE_BOOKS.getPercentage(), 0);
        assertEquals(20, Discount.FOUR_BOOKS.getPercentage(), 0);
        assertEquals(25, Discount.FIVE_BOOKS.getPercentage(), 0);
    }
}