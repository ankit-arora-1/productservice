package dev.ankit.productservice.repositories;

import dev.ankit.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitleAndPrice_currency(String title, String currency);

    @Query(value = "select * from product where title = :title", nativeQuery = true)
    Product findByTitle(String title);

    @Query(value = "select Product from Product where Product.title = :title", nativeQuery = false)
    Product findByTitle2(String title);
}

// added a comment
