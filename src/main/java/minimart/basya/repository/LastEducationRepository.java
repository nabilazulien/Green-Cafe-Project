package minimart.basya.repository;

import minimart.basya.model.LastEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LastEducationRepository extends JpaRepository<LastEducation, UUID>{
    Optional<LastEducation> findById (UUID id);
}
