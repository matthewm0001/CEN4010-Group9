package group9.geektext.dto;

public class BookDTOStandalone {
    private Long id;
    private String isbn;
    private String title;
    private String genre;
    private double price;
    private String description;
    private String publisher;
    private int yearPublished;    // Add this field
    private int copiesSold;       // Add this field
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorBiography;
    private String authorPublisher;

    // Constructor
    public BookDTOStandalone() {
    }

    public BookDTOStandalone(Long id, String isbn, String title, String genre, double price, String description, String publisher, int yearPublished, int copiesSold) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public BookDTOStandalone(Long id, String isbn, String title, String genre, double price, String description, String publisher, int yearPublished, int copiesSold, Long authorId, String authorFirstName, String authorLastName, String authorBiography, String authorPublisher) {
        this.publisher = publisher;
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorBiography = authorBiography;
        this.authorPublisher = authorPublisher;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public String getAuthorPublisher() {
        return authorPublisher;
    }

    public void setAuthorPublisher(String authorPublisher) {
        this.authorPublisher = authorPublisher;
    }
}