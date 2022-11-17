package minimart.basya.repository;

import minimart.basya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById (UUID id);

    Optional<User> findByLoginName(String loginName);
}
