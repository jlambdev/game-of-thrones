package main;

/**
 * Represents a Book
 */
public class Book {

    private String title;
    private double price;

    public Book(String title) {
        this.title = title;
        this.price = 8.0;
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
}
