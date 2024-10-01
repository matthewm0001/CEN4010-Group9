package group9.geektext.service;

import group9.geektext.dto.AuthorDTO;
import group9.geektext.dto.BookDTO;
import group9.geektext.entity.Book;
import group9.geektext.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Helper method to convert Book entity to BookDTO
    private BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getGenre(),
                book.getPrice(),
                book.getDescription(),   // Description field
                book.getPublisher(),     // Publisher field
                book.getYearPublished(), // Year Published field
                book.getCopiesSold(),    // Copies Sold field
                new AuthorDTO(book.getAuthor().getFirstName(), book.getAuthor().getLastName()) // AuthorDTO with first and last name
        );
    }
}
