package minimart.basya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Type(type = ("uuid-char"))
    private UUID Id;
    private String name;
    private String decription;
    private String category;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "updated_by", nullable = false)
    private User updatedBy;
}
