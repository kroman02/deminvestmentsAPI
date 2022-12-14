package dev.koryroman.demeterdocs.data.repos;

import dev.koryroman.demeterdocs.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Optional<Client> findClientByNameContaining(String name);


}
