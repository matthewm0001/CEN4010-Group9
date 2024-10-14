package group9.geektext.service;

import group9.geektext.dto.CreditCardDTO;
import group9.geektext.dto.UserDTO;
import group9.geektext.entity.CreditCard;
import group9.geektext.entity.User;
import group9.geektext.repository.UserRepository;
import group9.geektext.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CreditCardRepository creditCardRepository;

    // Constructor
    public UserService(UserRepository userRepository, CreditCardRepository creditCardRepository) {
        this.userRepository = userRepository;
        this.creditCardRepository = creditCardRepository;
    }

    // Retrieve user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Convert User entity to UserDTO, including credit cards
    public UserDTO convertToUserDTO(User user) {
        // Convert user's credit cards to CreditCardDTO
        List<CreditCardDTO> creditCardDTOs = user.getCreditCards().stream()
                .map(card -> new CreditCardDTO(
                        card.getCardNumber(),
                        card.getExpirationDate(),
                        card.getCvv(),
                        card.getCardHolderName()
                ))
                .collect(Collectors.toList());

        // Return UserDTO with credit cards
        return new UserDTO(
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getHomeAddress(),
                creditCardDTOs
        );
    }

    // Add a new credit card for a user
    public void addCreditCardToUser(String username, CreditCardDTO creditCardDTO) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            CreditCard creditCard = new CreditCard(
                    creditCardDTO.getCardNumber(),
                    creditCardDTO.getExpirationDate(),
                    creditCardDTO.getCvv(),
                    creditCardDTO.getCardHolderName()
            );
            creditCard.setUser(user);  // Associate the credit card with the user
            creditCardRepository.save(creditCard);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Update user details, excluding email
    public void updateUserDetails(String username, UserDTO userDTO) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // Update only the provided fields
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            user.setHomeAddress(userDTO.getHomeAddress());

            // Email is not updated, so it remains as it is
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Create a new user
    public void createUser(UserDTO userDTO) {
        User newUser = new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getHomeAddress()
        );
        userRepository.save(newUser);
    }
}
