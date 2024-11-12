package group9.geektext.service;

import group9.geektext.entity.ShoppingCart;
import group9.geektext.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import group9.geektext.entity.User;
import group9.geektext.repository.UserRepository;
import group9.geektext.entity.Book;
import group9.geektext.repository.BookRepository;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository,BookRepository bookRepository, UserRepository userRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    // Get shopping cart by user ID
    public Optional<ShoppingCart> getShoppingCartByUser(Long userId) {
        return shoppingCartRepository.findByUser_Id(userId);
    }

    // Create a new shopping cart
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Update an existing shopping cart
    public ShoppingCart updateShoppingCart(ShoppingCart updatedCart) {
        return shoppingCartRepository.save(updatedCart);  // save() will either create or update
    }

    // Delete a shopping cart by ID
    public void deleteShoppingCart(Long cartId) {
        shoppingCartRepository.deleteById(cartId);
    }

    // Add a book to the user's shopping cart
    public void addBookToCart(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        // Find or create a shopping cart for the user
        ShoppingCart cart = shoppingCartRepository.findByUser_Id(userId)
                .orElseGet(() -> shoppingCartRepository.save(new ShoppingCart(user)));

        // Find the book by ID
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        // Add the book to the cart's collection of books
        cart.getBooks().add(book);

        // Save the updated shopping cart
        shoppingCartRepository.save(cart);
    }
}


