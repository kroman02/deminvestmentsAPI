package dev.koryroman.demeterdocs.data.repos;


import dev.koryroman.demeterdocs.data.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
