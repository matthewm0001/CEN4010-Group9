package group9.geektext.service;

import group9.geektext.entity.Author;
import group9.geektext.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Get all authors. Sweet.
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Find author by ID
    public Optional<Author> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    // Save a new author
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Update an author
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Delete an author
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
