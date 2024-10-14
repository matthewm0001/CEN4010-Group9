package group9.geektext.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "creditcards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "expiration_date", nullable = false)
    private String expirationDate;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "card_holder_name", nullable = false)
    private String cardHolderName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // No-argument constructor (required by JPA)
    public CreditCard() {
    }

    // Parameterized constructor
    public CreditCard(String cardNumber, String expirationDate, String cvv, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
