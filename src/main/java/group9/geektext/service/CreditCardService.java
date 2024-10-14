package group9.geektext.service;

import group9.geektext.dto.CreditCardDTO;
import group9.geektext.entity.CreditCard;
import group9.geektext.entity.User;
import group9.geektext.repository.CreditCardRepository;
import group9.geektext.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final UserRepository userRepository;

    public CreditCardService(CreditCardRepository creditCardRepository, UserRepository userRepository) {
        this.creditCardRepository = creditCardRepository;
        this.userRepository = userRepository;
    }

    public List<CreditCard> getCreditCardsByUserId(Long userId) {
        return creditCardRepository.findByUserId(userId);  // Correct method
    }

    public CreditCard addCreditCard(String username, CreditCardDTO creditCardDTO) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        CreditCard creditCard = new CreditCard(
                creditCardDTO.getCardNumber(),
                creditCardDTO.getExpirationDate(),
                creditCardDTO.getCvv(),
                creditCardDTO.getCardHolderName()
        );
        creditCard.setUser(user);
        return creditCardRepository.save(creditCard);
    }
}
