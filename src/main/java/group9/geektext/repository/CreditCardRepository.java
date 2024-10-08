package group9.geektext.repository;

import group9.geektext.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByUser_Id(Long userId);  // Find credit cards by user ID
}
