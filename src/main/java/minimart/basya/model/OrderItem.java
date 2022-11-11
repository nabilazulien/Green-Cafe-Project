package minimart.basya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    @Type(type = ("uuid-char"))
    private UUID Id;
    @Type(type = ("uuid-char"))
    private UUID orderId;
    @Type(type = ("uuid-char"))
    private UUID itemId;
    private Integer quantity;
    private Double priceTotal;
    private String note;
}
