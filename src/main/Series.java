package main;

/**
 * Represents the Song of Ice and Fire (Game of Thrones) series.
 */
public enum Series {
    GAME_OF_THRONES("a game of thrones"),
    CLASH_OF_KINGS("a clash of kings"),
    STORM_OF_SWORDS("a storm of swords"),
    FEAST_FOR_CROWS("a feast for crows"),
    DANCE_WITH_DRAGONS("a dance with dragons");

    private String bookTitle;

    Series(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getTitle() {
        return this.bookTitle;
    }
}
