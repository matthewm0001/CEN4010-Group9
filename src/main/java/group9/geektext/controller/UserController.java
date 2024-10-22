package group9.geektext.controller;

import group9.geektext.dto.CreditCardDTO;
import group9.geektext.dto.UserDTO;
import group9.geektext.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET request to retrieve user by username
    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(userService::convertToUserDTO)  // Convert User to UserDTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST request to create a new user
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);  // Return 201 Created status
    }

    // POST request to add a credit card to the user
    @PostMapping("/{username}/creditcards")
    public ResponseEntity<Void> addCreditCardToUser(@PathVariable String username, @RequestBody CreditCardDTO creditCardDTO) {
        userService.addCreditCardToUser(username, creditCardDTO);
        return ResponseEntity.ok().build();
    }

    // PUT or PATCH request to update the user details, excluding email
    @PutMapping("/{username}")
    public ResponseEntity<Void> updateUserDetails(@PathVariable String username, @RequestBody UserDTO userDTO) {
        userService.updateUserDetails(username, userDTO);
        return ResponseEntity.ok().build();
    }
}
