package minimart.basya.repository;

import minimart.basya.model.PaymentType;
import minimart.basya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, UUID> {
    Optional<PaymentType> findById (UUID id);
}
