package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.EmployeeRequest;
import minimart.basya.model.Employee;
import minimart.basya.model.JobPosition;
import minimart.basya.model.LastEducation;
import minimart.basya.model.User;
import minimart.basya.repository.EmployeeRepository;
import minimart.basya.repository.JobPositionRepository;
import minimart.basya.repository.LastEducationRepository;
import minimart.basya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LastEducationRepository lastEducationRepository;
    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Override
    public ResponseEntity<Object> CreateNewEmployee(EmployeeRequest employeeRequest) {
        log.info("start create employee");
        Optional<JobPosition> jobPositionByTitle = jobPositionRepository.findByTitle(employeeRequest.getJobPositionId());
       if(!jobPositionByTitle.isPresent()){
           log.error("jobPositionId tidak sesuai");
           return new ResponseEntity<>("job jobPositionId tidak sesuai", HttpStatus.BAD_REQUEST);
       }

        Optional<LastEducation> lastEducationByName = lastEducationRepository.findByName(employeeRequest.getLastEducationId());
        if(!lastEducationByName.isPresent()){
            log.error("lastEducationId tidak sesuai");
            return new ResponseEntity<>("lastEducationId tidak sesuai", HttpStatus.BAD_REQUEST);
        }
        if(!employeeRequest.getCreatedBy().equals(employeeRequest.getUpdatedBy())){
            log.error("createdBy dan updateBy harus sama");
            return new ResponseEntity<>("createdBy dan updateBy harus sama", HttpStatus.BAD_REQUEST);
        }
       Optional<User> userByLoginName = userRepository.findByLoginName(employeeRequest.getCreatedBy());
        if(!userByLoginName.isPresent()){
            log.error("createdBy tidak sesuai");
            return new ResponseEntity<>("createdBy tidak sesuai", HttpStatus.BAD_REQUEST);
        }

        Employee employee = new Employee();

        employee.setJobPositionId(jobPositionByTitle.get());
        employee.setLastEducationId(lastEducationByName.get());
        employee.setCreatedBy(userByLoginName.get());
        employee.setUpdatedBy(userByLoginName.get());
        //---------------------//------------------//
        employee.setId(UUID.randomUUID());
        employee.setFullName(employeeRequest.getFullName());
        employee.setGender(employeeRequest.getGender());
        employee.setDob(LocalDate.parse(employeeRequest.getDob()));
        employee.setPob(employeeRequest.getPob());
        employee.setEmail(employeeRequest.getEmail());
        employee.setMobilePhoneNumber(employeeRequest.getMobilePhoneNumber());
        employee.setCreatedAt(LocalDateTime.now());
        employee.setIsActive(true);
        employeeRepository.save(employee);
        log.info("save employee berhasil");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
