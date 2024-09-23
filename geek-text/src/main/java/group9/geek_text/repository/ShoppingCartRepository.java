package group9.geektext.repository;

import group9.geektext.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUser_Id(Long userId);  // Find shopping cart by user ID
}
