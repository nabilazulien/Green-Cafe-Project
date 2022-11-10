package minimart.basya.repository;

import minimart.basya.model.OrderItem;
import minimart.basya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    Optional<OrderItem> findById (UUID id);
}
