package group9.geektext.service;

import group9.geektext.dto.AuthorFullDTO;
import group9.geektext.dto.BookDTO;
import group9.geektext.entity.Author;
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

    public BookDTO createBook(BookDTO bookDTORequest) {
        Book book = convertToEntity(bookDTORequest); // Convert DTO to entity
        Book savedBook = bookRepository.save(book); // Save the entity

        return convertToDTO(savedBook);
    }

    // Update an existing book
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setIsbn(bookDTO.getIsbn());
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setGenre(bookDTO.getGenre());
            existingBook.setPrice(bookDTO.getPrice());
            existingBook.setDescription(bookDTO.getDescription());
            existingBook.setPublisher(bookDTO.getPublisher());
            existingBook.setYearPublished(bookDTO.getYearPublished());
            existingBook.setCopiesSold(bookDTO.getCopiesSold());

            Book updatedBook = bookRepository.save(existingBook); // Save the updated entity
            return convertToDTO(updatedBook); // Return the updated entity as a DTO
        }).orElse(null); // Return null if the author is not found
    }

    // Delete an author by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


    // Convert an BookDTO to an Book entity
    private Book convertToEntity(BookDTO bookDTORequest) {
        Book book = new Book();
        book.setId(bookDTORequest.getId());
        book.setIsbn(bookDTORequest.getIsbn());
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

    // Helper method to convert Book entity to BookDTO
    private BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getGenre(),
                book.getPrice(),
                book.getDescription(), // Description field
                book.getPublisher(), // Publisher field
                book.getYearPublished(), // Year Published field
                book.getCopiesSold(), // Copies Sold field
                book.getAuthor()
        );
    }

    // Convert an Author entity to AuthorFullDTO
    private AuthorFullDTO convertAuthorToDTO(Author author) {
        return new AuthorFullDTO(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBiography(),
                author.getPublisher(),
                author.getBooks().stream()
                        .map(this::convertToDTO) // Convert each Book entity to BookDTO
                        .collect(Collectors.toList()));
    }
}
