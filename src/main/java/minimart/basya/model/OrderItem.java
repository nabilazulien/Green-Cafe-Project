package minimart.basya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @OneToOne(targetEntity = Orders.class)
    @JoinColumn(name = "order_id")
    private Orders orderId;

    @OneToOne(targetEntity = Item.class)
    @JoinColumn(name = "item_id", nullable = false)
    private Item itemId;

    private Integer quantity;
    private Double priceTotal;
    private String note;
}
