package main;

/**
 * Represents book discounts
 */
public enum Discount {
    ONE_BOOK(0),
    TWO_BOOKS(5),
    THREE_BOOKS(10),
    FOUR_BOOKS(20),
    FIVE_BOOKS(25);

    private int percentage;

    Discount(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() { return this.percentage; }
}
