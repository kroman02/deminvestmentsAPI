package dev.koryroman.demeterdocs.data.repos;

import dev.koryroman.demeterdocs.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
