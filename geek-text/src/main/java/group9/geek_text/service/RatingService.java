package group9.geektext.service;

import group9.geektext.entity.Rating;
import group9.geektext.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // Get all ratings for a specific book
    public List<Rating> getRatingsByBook(Long bookId) {
        return ratingRepository.findByBook_Id(bookId);
    }

    // Get all ratings from a specific user
    public List<Rating> getRatingsByUser(Long userId) {
        return ratingRepository.findByUser_Id(userId);
    }

    // Save a new rating
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Update a rating
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Delete a rating
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }
}
