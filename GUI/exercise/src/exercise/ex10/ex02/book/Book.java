package exercise.ex10.ex02.book;

public enum Book {

    EXAMPLE_BOOK("Example", new Author("Author", "Main"), 20.0);

    private final String title;
    private final Author author;
    private final double price;

    Book(final String title, final Author author, final double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
