package ch.wiss1.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    // Derived Queries
    List<Product> findByNameEndingWith(String name);

    Product findFirstByOrderByPriceDesc();

    // Native Query
    @Query(value = "SELECT * FROM product ORDER BY PRICE DESC LIMIT 1", nativeQuery = true)
    Product findFirstProductNativeQuery();


}
