package group9.geektext.controller;

import group9.geektext.dto.BookDTO;
import group9.geektext.dto.BookDTOAuthorID;
import group9.geektext.dto.BookDTOStandalone;
import group9.geektext.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books") // Base URL for books
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @GetMapping
    public List<BookDTOStandalone> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTOStandalone> getBookById(@PathVariable Long id) {
        BookDTOStandalone book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookDTOStandalone> createBook(@RequestBody BookDTO book) {
        // Create a new book
        BookDTOStandalone createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<BookDTOAuthorID> updateAuthor(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTOAuthorID updatedBook = bookService.updateBook(id, bookDTO);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
