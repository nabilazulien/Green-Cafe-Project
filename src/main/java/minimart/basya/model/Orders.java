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
public class Orders {
    @Id
    @GeneratedValue
    @Type(type = ("uuid-char"))
    private UUID Id;
    private String code;
    @Type(type = ("uuid-char"))
    private UUID cashier;
    private Double total;
    private Double subTotal;
    private Double tax;
    @Type(type = ("uuid-char"))
    private UUID paymentTypeId;
    private LocalDate createdAt;
}
