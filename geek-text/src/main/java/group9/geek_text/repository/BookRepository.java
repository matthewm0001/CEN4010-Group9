package group9.geektext.repository;

import group9.geektext.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);  // Search books by title
    List<Book> findByGenre(String genre);  // Find books by genre
    List<Book> findByAuthor_Id(Long authorId);  // Find books by author ID
}
