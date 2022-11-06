package dev.koryroman.demeterdocs.data.repos;

import dev.koryroman.demeterdocs.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
