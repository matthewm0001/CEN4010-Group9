package group9.geektext.dto;

public class AuthorDTO {
    private String fullName; // Combined firstName and lastName

    // Constructor
    public AuthorDTO(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName; // Concatenate first and last name
    }

    // Getter for full name
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}