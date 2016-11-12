package main;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents and computes an appropriate discount
 */
public class DiscountCalculator {

    private Basket basket;

    public DiscountCalculator(Basket basket) {
        this.basket = basket;
    }

    public double getDiscount() {
        // TODO: identify and apply discounts based on series in the basket
        Set<Book> itemSet = new HashSet<>(this.basket.getItems());
        switch(itemSet.size()) {
            case 5:
                return (this.basket.getTotal() / 100) *
                        Discount.FIVE_BOOKS.getPercentage();
            case 4:
                return (this.basket.getTotal() / 100) *
                        Discount.FOUR_BOOKS.getPercentage();
            case 3:
                return (this.basket.getTotal() / 100) *
                        Discount.THREE_BOOKS.getPercentage();
            case 2:
                return (this.basket.getTotal() / 100) *
                        Discount.TWO_BOOKS.getPercentage();
            default:
                return Discount.ONE_BOOK.getPercentage();
        }
    }
}
