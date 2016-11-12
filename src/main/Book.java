package main;

/**
 * Represents a Book
 */
public class Book {

    public static double STANDARD_PRICE = 8.0;

    private String title;
    private double price;

    public Book(String title) {
        if (!isTitleInSeries(title)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.price = STANDARD_PRICE;
    }

    private boolean isTitleInSeries(String title) {
        for (Series seriesBook : Series.values()) {
            if (title.toLowerCase().equals(seriesBook.getTitle())) return true;
        }
        return false;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (!Book.class.isAssignableFrom(obj.getClass())) { return false; }
        Book other = (Book) obj;
        return this.title.equals(other.getTitle());
    }

    public int hashCode() {
        int result = 17;
        return 31 * result + this.title.hashCode();
    }

    public String toString() {
        return this.title;
    }
}
