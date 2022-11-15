package minimart.basya.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobPosition {
    @Id
    @GeneratedValue
    @Type(type = ("uuid-char"))
    private UUID id;
    private String title;
    private Double salary;
    private LocalDateTime createdAt;
}
