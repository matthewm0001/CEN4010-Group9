package group9.geektext.controller;

import group9.geektext.dto.AuthorDTO;
import group9.geektext.dto.AuthorDTOStandalone;
import group9.geektext.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Get all authors
    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // Get a single author by ID
    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long authorId) {
        AuthorDTO author = authorService.getAuthorById(authorId);
        return author != null ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }

    // Create a new author
    @PostMapping
    public ResponseEntity<AuthorDTOStandalone> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTOStandalone createdAuthor = authorService.createAuthor(authorDTO);
        return ResponseEntity.ok(createdAuthor);
    }

    // Update an author
    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO updatedAuthor = authorService.updateAuthor(authorId, authorDTO);
        return updatedAuthor != null ? ResponseEntity.ok(updatedAuthor) : ResponseEntity.notFound().build();
    }

    // Delete an author
    @DeleteMapping("/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.noContent().build();
    }
}