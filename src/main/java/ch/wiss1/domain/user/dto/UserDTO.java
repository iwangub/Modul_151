package ch.wiss1.domain.user.dto;

import ch.wiss1.domain.product.Product;

import java.util.Set;

public class UserDTO {

    private String firstName;
    private String lastName;

    public UserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
