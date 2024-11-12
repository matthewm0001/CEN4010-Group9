package group9.geektext.service;

import group9.geektext.entity.Book;
import group9.geektext.entity.Wishlist;
import group9.geektext.repository.WishlistRepository;
import group9.geektext.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final BookRepository bookRepository;
    private final ShoppingCartService shoppingCartService;


    public WishlistService(WishlistRepository wishlistRepository, BookRepository bookRepository,
                           ShoppingCartService shoppingCartService) {
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;
        this.shoppingCartService = shoppingCartService;
    }

    // Get all wishlists for a user
    public List<Wishlist> getWishlistsByUser(Long userId) {
        return wishlistRepository.findByUser_Id(userId);
    }

    // Get a specific wishlist by ID
    public Optional<Wishlist> getWishlistById(Long wishlistId) {
        return wishlistRepository.findById(wishlistId);
    }

    // Save a new wishlist
    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    // Update a wishlist
    public Wishlist updateWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    // Delete a wishlist
    public void deleteWishlist(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }

    // Add a book to a wishlist
    public void addBookToWishlist(Long wishlistId, Long bookId) {
        // Find the wishlist by ID
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new NoSuchElementException("Wishlist not found"));

        // Find the book by ID
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        // Add the book to the wishlist's book collection
        wishlist.getBooks().add(book);

        // Save the updated wishlist
        wishlistRepository.save(wishlist);
    }
    public void removeBookFromWishlist(Long wishlistId, Long bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new NoSuchElementException("Wishlist not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        wishlist.getBooks().remove(book);
        wishlistRepository.save(wishlist);
        }

    public List<Book> getBooksInWishlist(Long wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new NoSuchElementException("Wishlist not found"));

        return wishlist.getBooks();

    }

    public void moveBookToShoppingCart(Long wishlistId, Long bookId, Long userId) {
        // Find the wishlist and book
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new NoSuchElementException("Wishlist not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        // Remove the book from the wishlist
        wishlist.getBooks().remove(book);
        wishlistRepository.save(wishlist);

        // Add the book to the user's shopping cart (assuming ShoppingCartService has an 'addBookToCart' method)
        shoppingCartService.addBookToCart(userId, bookId);
    }

}
