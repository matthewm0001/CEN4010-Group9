package group9.geektext.service;

import group9.geektext.dto.*;
import group9.geektext.entity.Author;
import group9.geektext.entity.Book;
import group9.geektext.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Fetch all authors and convert to AuthorFullDTOs
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::convertToDTO) // Convert each Author entity to AuthorFullDTO
                .collect(Collectors.toList());
    }

    // Fetch a single author by ID and convert to AuthorFullDTO
    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(this::convertToDTO) // Convert to DTO if the author is found
                .orElse(null); // Return null if the author is not found
    }

    // Create a new author
    public AuthorDTOStandalone createAuthor(AuthorDTO authorDTO) {
        Author author = convertToEntity(authorDTO); // Convert DTO to entity
        Author savedAuthor = authorRepository.save(author); // Save the entity
        return convertToDTOStandalone(savedAuthor); // Return saved entity as DTO
    }

    // Update an existing author
    public AuthorDTO updateAuthor(Long authorId, AuthorDTO authorDTO) {
        return authorRepository.findById(authorId).map(existingAuthor -> {
            existingAuthor.setFirstName(authorDTO.getFirstName());
            existingAuthor.setLastName(authorDTO.getLastName());
            existingAuthor.setBiography(authorDTO.getBiography());
            existingAuthor.setPublisher(authorDTO.getPublisher());

            Author updatedAuthor = authorRepository.save(existingAuthor); // Save the updated entity
            return convertToDTO(updatedAuthor); // Return the updated entity as a DTO
        }).orElse(null); // Return null if the author is not found
    }

    // Delete an author by ID
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    // Convert an Author entity to AuthorDTO
    private AuthorDTO convertToDTO(Author author) {
        return new AuthorDTO(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBiography(),
                author.getPublisher(),
                author.getBooks().stream()
                        .map(this::convertBookToDTO) // Convert each Book entity to BookDTOMin
                        .collect(Collectors.toList()));
    }

    // Convert an Author entity to AuthorDTOStandalone
    private AuthorDTOStandalone convertToDTOStandalone(Author author) {
            return new AuthorDTOStandalone(
                    author.getId(),
                    author.getFirstName(),
                    author.getLastName(),
                    author.getBiography(),
                    author.getPublisher());
        }

    // Helper method to convert Book entity to BookDTOMin
    private BookDTOMin convertBookToDTO(Book book) {
        return new BookDTOMin(
                book.getId(), // ID field
                book.getIsbn(), // ISBN field
                book.getTitle(), // Title field
                book.getGenre(), // Genre field
                book.getPrice(), // Price field
                book.getDescription(), // Description field
                book.getPublisher(), // Publisher field
                book.getYearPublished(), // Year Published field
                book.getCopiesSold()  // Copies Sold field
        );
    }

    // Convert an AuthorDTO to an Author entity
    private Author convertToEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setBiography(authorDTO.getBiography());
        author.setPublisher(authorDTO.getPublisher());
        return author;
    }
}
