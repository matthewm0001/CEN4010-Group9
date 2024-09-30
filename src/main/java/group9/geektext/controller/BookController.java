package group9.geektext.controller;

import group9.geektext.entity.Book;
import group9.geektext.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get")
    public List<Book> getAllBooks() {
        // Return all books as full `Book` entities (with complete Author info)
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        // Get a specific book by its ID
        Book book = bookService.getBookById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Create a new book
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        // Update a book
        Book book = bookService.updateBook(id, updatedBook);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Delete a book by its ID
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
