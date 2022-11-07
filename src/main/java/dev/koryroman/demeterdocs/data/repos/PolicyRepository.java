package dev.koryroman.demeterdocs.data.repos;

import dev.koryroman.demeterdocs.data.MyPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<MyPolicy, Long> {
    @Override
    boolean existsById(Long aLong);
}
