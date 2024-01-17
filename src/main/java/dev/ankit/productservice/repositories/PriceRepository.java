package dev.ankit.productservice.repositories;

import dev.ankit.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}
