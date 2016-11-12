package main;

import java.util.*;

/**
 * Represents and computes an appropriate discount
 */
public class DiscountCalculator {

    private Basket basket;

    public DiscountCalculator(Basket basket) {
        this.basket = basket;
    }

    public double getTotalDiscounts() {
        // Create a book title count
        Map<String, MutableInt> bookCounts = new HashMap<>();
        for (Book book : this.basket.getItems()) {
            if (!bookCounts.containsKey(book.getTitle().toLowerCase())) {
                bookCounts.put(book.getTitle().toLowerCase(), new MutableInt());
            } else {
                bookCounts.get(book.getTitle().toLowerCase()).increment();
            }
        }
        // Calculate the sum of all discounts
        double totalDiscounts = 0;
        while (!bookCounts.isEmpty()) {
            int seriesCount = 0;
            for (Series seriesBook : Series.values()) {
                if (bookCounts.containsKey(seriesBook.getTitle())) {
                    seriesCount++;
                    MutableInt count = bookCounts.get(seriesBook.getTitle());
                    if (count.get() > 1) {
                        count.decrement();
                    } else {
                        bookCounts.remove(seriesBook.getTitle());
                    }
                }
            }
            totalDiscounts += getSeriesDiscount(seriesCount);
        }
        return totalDiscounts;
    }

    public static double getSeriesDiscount(int seriesCount) {
        double totalBeforeDiscounts = Book.STANDARD_PRICE * seriesCount;
        switch(seriesCount) {
            case 5:
                return (totalBeforeDiscounts / 100) *
                        Discount.FIVE_BOOKS.getPercentage();
            case 4:
                return (totalBeforeDiscounts / 100) *
                        Discount.FOUR_BOOKS.getPercentage();
            case 3:
                return (totalBeforeDiscounts / 100) *
                        Discount.THREE_BOOKS.getPercentage();
            case 2:
                return (totalBeforeDiscounts / 100) *
                        Discount.TWO_BOOKS.getPercentage();
            default:
                return Discount.ONE_BOOK.getPercentage();
        }
    }
}
