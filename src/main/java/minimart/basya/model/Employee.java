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
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;
    private String fullName;
    private String gender;
    private LocalDate dob;
    private String pob;
    private String email;
    private String mobilePhoneNumber;
    private UUID lastEducationId;
    private UUID jobPositionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
    private Boolean isActive;
}
