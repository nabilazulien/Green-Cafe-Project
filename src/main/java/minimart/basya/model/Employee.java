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
    @Type(type = ("uuid-char"))
    private UUID id;
    private String fullName;
    private String gender;
    private LocalDate dob;
    private String pob;
    private String email;
    private String mobilePhoneNumber;
    @Type(type = ("uuid-char"))
    private UUID lastEducationId;
    @Type(type = ("uuid-char"))
    private UUID jobPositionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Type(type = ("uuid-char"))
    private UUID createdBy;
    @Type(type = ("uuid-char"))
    private UUID updatedBy;
    private Boolean isActive;
}
