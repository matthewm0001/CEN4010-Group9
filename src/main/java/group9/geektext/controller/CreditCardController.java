package group9.geektext.controller;

import group9.geektext.entity.CreditCard;
import group9.geektext.service.CreditCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    // Retrieve credit cards by user ID
    @GetMapping("/{userId}/creditcards")
    public List<CreditCard> getCreditCardsByUserId(@PathVariable Long userId) {
        return creditCardService.getCreditCardsByUserId(userId);  // Corrected method call
    }
}
