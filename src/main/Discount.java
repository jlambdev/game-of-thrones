package main;

/**
 * Created by JL on 12/11/2016.
 */
public enum Discount {
    ONE_BOOK(0),
    TWO_BOOKS(5),
    THREE_BOOKS(10),
    FOUR_BOOKS(20),
    FIVE_BOOKS(25);

    private int percentage;

    private Discount(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() { return this.percentage; }
}
