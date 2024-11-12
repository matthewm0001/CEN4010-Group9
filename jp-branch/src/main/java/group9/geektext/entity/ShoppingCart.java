package group9.geektext.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
        name = "cart_books",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    // Constructors
    public ShoppingCart() {}

    public ShoppingCart(User user) {
        this.user = user;
    }

    public ShoppingCart(User user, List<Book> books) {
        this.user = user;
        this.books = books;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
