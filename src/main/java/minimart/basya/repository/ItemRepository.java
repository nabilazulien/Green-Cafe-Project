package minimart.basya.repository;

import minimart.basya.model.Item;
import minimart.basya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
    Optional<Item> findById (UUID id);
}
