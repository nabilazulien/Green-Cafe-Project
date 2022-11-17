package minimart.basya.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import minimart.basya.model.JobPosition;
import minimart.basya.model.LastEducation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
public class EmployeeRequest {
    private String fullName;
    private String gender;
    private String dob;
    private String pob;
    private String email;
    private String mobilePhoneNumber;
    private LocalDateTime createAt;
    private UUID createdBy;
    private Boolean isActive;
    private JobPosition jobPositionId;
    private LastEducation lastEducationId;
}
