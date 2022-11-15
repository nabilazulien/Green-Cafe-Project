package minimart.basya.repository;

import minimart.basya.model.JobPosition;
import minimart.basya.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobPositionRepository extends JpaRepository<JobPosition, UUID> {
    Optional<JobPosition> findById (UUID id);

}
