package group9.geektext.service;

import group9.geektext.entity.Book;
import group9.geektext.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Find book by ID
    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    // Search books by title
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    // Find books by genre
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    // Find books by author
    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthor_Id(authorId);
    }

    // Save a new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Update a book
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete a book
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
