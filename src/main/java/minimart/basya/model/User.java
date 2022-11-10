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
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID Id;
    private String fullName;
    private String email;
    private String mobilePhoneNumber;
    private String workPhoneNumber;
    private String loginName;
    private String password;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
