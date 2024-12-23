package group9.geektext.dto;

import group9.geektext.entity.Author;

public class BookDTO {
    private Long isbn;
    private String title;
    private String genre;
    private double price;
    private String description;
    private String publisher;
    private int yearPublished;    // Add this field
    private int copiesSold;       // Add this field
    private Author author;     // AuthorDTO contains only firstName and lastName

    // Constructor
    public BookDTO() {
    }

    public BookDTO(Long isbn, String title, String genre, double price, String description, String publisher, int yearPublished, int copiesSold, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.author = author;
    }

    public BookDTO(Long isbn, String title, String genre, double price, String description, String publisher, int yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    // Getters and Setters

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}