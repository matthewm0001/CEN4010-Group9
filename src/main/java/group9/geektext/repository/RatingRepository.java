package group9.geektext.repository;

import group9.geektext.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByBook_Id(Long bookId);  // Find ratings by book ID
    List<Rating> findByUser_Id(Long userId);  // Find ratings by user ID
}
