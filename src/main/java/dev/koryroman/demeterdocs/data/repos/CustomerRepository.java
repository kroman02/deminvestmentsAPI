package dev.koryroman.demeterdocs.data.repos;

import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomersByClient(Client client);
}
