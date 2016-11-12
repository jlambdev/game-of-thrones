package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a shopping basket
 */
public class Basket {

    private List<Book> items;
    private double total;

    public Basket() {
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public List<Book> getItems() {
        return this.items;
    }

    public double getTotal() {
        return this.total;
    }

    public double getTotalAfterDiscounts() {
        DiscountCalculator discApplier = new DiscountCalculator(this);
        applyDiscount(discApplier.getTotalDiscounts());
        return this.total;
    }

    private void applyDiscount(double discount) {
        this.total = this.total - discount;
    }

    public void addItem(Book book) {
        this.items.add(book);
        this.total += book.getPrice();
    }
}
