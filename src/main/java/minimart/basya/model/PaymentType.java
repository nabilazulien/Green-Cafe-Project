package minimart.basya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType {
    @Id
    @GeneratedValue
    private UUID Id;
    private String name;
    private String code;
    private LocalDate createdBy;
}
