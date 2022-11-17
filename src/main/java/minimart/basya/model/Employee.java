package minimart.basya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @ManyToOne(targetEntity = LastEducation.class)
    @JoinColumn(name = "last_education_id", nullable = false)
    private LastEducation lastEducationId;

    @ManyToOne(targetEntity = JobPosition.class)
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPositionId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "updated_by", nullable = false)
    private User updatedBy;

    private Boolean isActive;
}
