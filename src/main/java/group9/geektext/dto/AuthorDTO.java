package group9.geektext.dto;
import java.util.List;

public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;
    private List<BookDTOMin> books;  // List of books the author has written

    // Constructor
    public AuthorDTO() {
    }

    // Constructor
    public AuthorDTO(Long id, String firstName, String lastName, String biography, String publisher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    public AuthorDTO(Long id, String firstName, String lastName, String biography, String publisher, List<BookDTOMin> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
        this.books = books;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<BookDTOMin> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTOMin> books) {
        this.books = books;
    }
}