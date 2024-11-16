package group9.geektext.service;

import group9.geektext.dto.AuthorDTOStandalone;
import group9.geektext.dto.BookDTO;
import group9.geektext.dto.BookDTOAuthorID;
import group9.geektext.dto.BookDTOStandalone;
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

    public List<BookDTOStandalone> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTOStandalone)
                .collect(Collectors.toList());
    }

    public BookDTOStandalone getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToDTOStandalone)
                .orElse(null);
    }

    public BookDTOStandalone createBook(BookDTO bookDTORequest) {
        Book book = convertToEntity(bookDTORequest); // Convert DTO to entity
        Book savedBook = bookRepository.save(book); // Save the entity

        return convertToDTOStandalone(savedBook);
    }

    // Update an existing book
    public BookDTOAuthorID updateBook(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setGenre(bookDTO.getGenre());
            existingBook.setPrice(bookDTO.getPrice());
            existingBook.setDescription(bookDTO.getDescription());
            existingBook.setPublisher(bookDTO.getPublisher());
            existingBook.setYearPublished(bookDTO.getYearPublished());
            existingBook.setCopiesSold(bookDTO.getCopiesSold());
            existingBook.setAuthor(bookDTO.getAuthor());

            Book updatedBook = bookRepository.save(existingBook); // Save the updated entity
            return convertToDTOAuthorID(updatedBook); // Return the updated entity as a DTO
        }).orElse(null); // Return null if the author is not found
    }

    // Delete an author by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


    // Convert an BookDTO to a Book entity
    private Book convertToEntity(BookDTO bookDTORequest) {
        Book book = new Book();
        book.setId(bookDTORequest.getIsbn());
        book.setTitle(bookDTORequest.getTitle());
        book.setGenre(bookDTORequest.getGenre());
        book.setPrice(bookDTORequest.getPrice());
        book.setDescription(bookDTORequest.getDescription());
        book.setPublisher(bookDTORequest.getPublisher());
        book.setYearPublished(bookDTORequest.getYearPublished());
        book.setCopiesSold(bookDTORequest.getCopiesSold());
        book.setAuthor(bookDTORequest.getAuthor());
        return book;
    }

    // Helper method to convert Book entity to BookDTOStandalone
    private BookDTOStandalone convertToDTOStandalone(Book book) {
    AuthorDTOStandalone author = new AuthorDTOStandalone(book.getAuthorId(), book.getAuthorFirstName(), book.getAuthorLastName(), book.getAuthorBiography(), book.getAuthorPublisher());

        return new BookDTOStandalone(
                book.getId(), // ISBN field
                book.getTitle(), // Title field
                book.getGenre(), // Genre field
                book.getPrice(), // Price field
                book.getDescription(), // Description field
                book.getPublisher(), // Publisher field
                book.getYearPublished(), // Year Published field
                book.getCopiesSold(), // Copies Sold field
                author // AuthorDTO object without book list
        );
    }

    // Helper method to convert Book entity to BookDTOAuthorID
    private BookDTOAuthorID convertToDTOAuthorID(Book book) {

        return new BookDTOAuthorID(
                book.getId(), // ISBN field
                book.getTitle(), // Title field
                book.getGenre(), // Genre field
                book.getPrice(), // Price field
                book.getDescription(), // Description field
                book.getPublisher(), // Publisher field
                book.getYearPublished(), // Year Published field
                book.getCopiesSold(), // Copies Sold field
                book.getAuthorId() // AuthorDTO object without book list
        );
    }

}
