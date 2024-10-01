package group9.geektext.service;

import group9.geektext.dto.AuthorFullDTO;
import group9.geektext.dto.BookDTO;
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
    public List<AuthorFullDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::convertToDTO)  // Convert each Author entity to AuthorFullDTO
                .collect(Collectors.toList());
    }

    // Fetch a single author by ID and convert to AuthorFullDTO
    public AuthorFullDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(this::convertToDTO)  // Convert to DTO if the author is found
                .orElse(null);  // Return null if the author is not found
    }

    // Create a new author
    public AuthorFullDTO createAuthor(AuthorFullDTO authorDTO) {
        Author author = convertToEntity(authorDTO);  // Convert DTO to entity
        Author savedAuthor = authorRepository.save(author);  // Save the entity
        return convertToDTO(savedAuthor);  // Return saved entity as DTO
    }

    // Update an existing author
    public AuthorFullDTO updateAuthor(Long authorId, AuthorFullDTO authorDTO) {
        return authorRepository.findById(authorId).map(existingAuthor -> {
            existingAuthor.setFirstName(authorDTO.getFirstName());
            existingAuthor.setLastName(authorDTO.getLastName());
            existingAuthor.setBiography(authorDTO.getBiography());
            // Add other fields as necessary...

            Author updatedAuthor = authorRepository.save(existingAuthor);  // Save the updated entity
            return convertToDTO(updatedAuthor);  // Return the updated entity as a DTO
        }).orElse(null);  // Return null if the author is not found
    }

    // Delete an author by ID
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    // Convert an Author entity to AuthorFullDTO
    private AuthorFullDTO convertToDTO(Author author) {
        return new AuthorFullDTO(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBiography(),
                author.getBooks().stream()
                        .map(this::convertBookToDTO)  // Convert each Book entity to BookDTO
                        .collect(Collectors.toList())
        );
    }

    // Helper method to convert Book entity to BookDTO
    private BookDTO convertBookToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getGenre(),
                book.getPrice(),
                book.getDescription(),  // Include the description field
                book.getPublisher(),    // Include the publisher field
                book.getYearPublished(),  // Add yearPublished field
                book.getCopiesSold(),     // Add copiesSold field
                null  // No need for AuthorDTO here to avoid circular reference
        );
    }

    // Convert an AuthorFullDTO to an Author entity
    private Author convertToEntity(AuthorFullDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setBiography(authorDTO.getBiography());
        // Add other fields if necessary...
        return author;
    }
}
