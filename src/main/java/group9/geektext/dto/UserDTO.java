package group9.geektext.dto;

import java.util.List;

public class UserDTO {

    private String username;
    private String password;
    private String name;
    private String email;
    private String homeAddress;
    private List<CreditCardDTO> creditCards; // Include credit card list

    // No-argument constructor
    public UserDTO() {}

    // Parameterized constructor
    public UserDTO(String username, String password, String name, String email, String homeAddress, List<CreditCardDTO> creditCards) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.homeAddress = homeAddress;
        this.creditCards = creditCards;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public List<CreditCardDTO> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCardDTO> creditCards) {
        this.creditCards = creditCards;
    }
}
