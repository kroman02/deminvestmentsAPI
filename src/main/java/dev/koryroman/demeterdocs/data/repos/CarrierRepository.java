package dev.koryroman.demeterdocs.data.repos;

import dev.koryroman.demeterdocs.data.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
}
