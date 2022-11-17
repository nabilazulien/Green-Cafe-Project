package minimart.basya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @OneToOne(targetEntity = Employee.class)
    @JoinColumn(name = "cashier", nullable = false)
    private Employee cashier;

    private Double total;
    private Double subTotal;
    private Double tax;

    @OneToOne(targetEntity = PaymentType.class)
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentTypeId;
    private LocalDate createdAt;
}
