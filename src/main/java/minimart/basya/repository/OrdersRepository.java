package minimart.basya.repository;

import minimart.basya.model.Orders;
import minimart.basya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {
    Optional<Orders> findById (UUID id);
}
