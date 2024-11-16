package group9.geektext.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "copies_sold", nullable = false)
    private int copiesSold;

    @Column(name = "year_published", nullable = false)
    private int yearPublished;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "books_ibfk_1"))
    private Author author; // Full Author object without DTO

    // Constructors
    public Book() {
    }

    public Book(String isbn, String title, String genre, String description, String publisher, double price,
            int copiesSold, int yearPublished, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
        this.copiesSold = copiesSold;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) {this.author = author;}

    public Long getAuthorId() { return this.author.getId(); }

    public String getAuthorFirstName( ) { return this.author.getFirstName(); }

    public String getAuthorLastName( ) { return this.author.getLastName(); }

    public String getAuthorBiography( ) { return this.author.getBiography(); }

    public String getAuthorPublisher( ) { return this.author.getPublisher(); }
}
