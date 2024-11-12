package group9.geektext.repository;

import group9.geektext.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUser_Id(Long userId);  // Find wishlists by user ID
}
