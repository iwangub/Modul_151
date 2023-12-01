package ch.wiss1.domain.user;

import ch.wiss1.domain.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "account_locked")
    private Boolean isAccountLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_product",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    Set<Product> products;

    public User() {

    }

    public User(UUID id, String firstName, String lastName, Boolean isAccountLocked, Set<Product> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAccountLocked = isAccountLocked;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getAccountLocked() {
        return isAccountLocked;
    }

    public User setAccountLocked(Boolean accountLocked) {
        isAccountLocked = accountLocked;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public User setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }
}
