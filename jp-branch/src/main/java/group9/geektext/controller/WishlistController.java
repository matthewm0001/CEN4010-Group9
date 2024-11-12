package group9.geektext.controller;

import group9.geektext.entity.Wishlist;
import group9.geektext.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import group9.geektext.entity.Book;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // Get all wishlists for a user
    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUser(@PathVariable Long userId) {
        return wishlistService.getWishlistsByUser(userId);
    }

    // Get a specific wishlist by ID
    @GetMapping("/{wishlistId}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long wishlistId) {
        Optional<Wishlist> wishlist = wishlistService.getWishlistById(wishlistId);
        return wishlist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new wishlist
    @PostMapping
    public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
        return ResponseEntity.ok(wishlistService.createWishlist(wishlist));
    }

    // Delete a wishlist
    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
        return ResponseEntity.noContent().build();
    }

    // Adding book to wishlist
    @PostMapping("/{wishlistId}/books/{bookId}")
    public ResponseEntity<Void> addBookToWishlist(@PathVariable Long wishlistId, @PathVariable Long bookId) {
        wishlistService.addBookToWishlist(wishlistId, bookId);
        return ResponseEntity.ok().build();
    }

    // Remove a book from a wishlist
    @DeleteMapping("/{wishlistId}/books/{bookId}")
    public ResponseEntity<Void> removeBookFromWishlist(@PathVariable Long wishlistId, @PathVariable Long bookId) {
        wishlistService.removeBookFromWishlist(wishlistId, bookId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{wishlistId}/books/{bookId}/move-to-cart/{userId}")
    public ResponseEntity<Void> moveBookToShoppingCart(@PathVariable Long wishlistId, @PathVariable Long bookId,
                                                       @PathVariable Long userId) {
        wishlistService.moveBookToShoppingCart(wishlistId, bookId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{wishlistId}/books")
    public ResponseEntity<List<Book>> getBooksInWishlist(@PathVariable Long wishlistId) {
        List<Book> books = wishlistService.getBooksInWishlist(wishlistId);
        return ResponseEntity.ok(books);
    }

}
