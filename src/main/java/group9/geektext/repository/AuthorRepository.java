package group9.geektext.repository;

import group9.geektext.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorByIdForBook(Long authorId);
}
