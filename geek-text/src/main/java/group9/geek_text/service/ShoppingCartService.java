package group9.geektext.service;

import group9.geektext.entity.ShoppingCart;
import group9.geektext.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    // Get the shopping cart for a user
    public Optional<ShoppingCart> getShoppingCartByUser(Long userId) {
        return shoppingCartRepository.findByUser_Id(userId);
    }

    // Save a new shopping cart
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Update the shopping cart
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Delete a shopping cart
    public void deleteShoppingCart(Long cartId) {
        shoppingCartRepository.deleteById(cartId);
    }
}
