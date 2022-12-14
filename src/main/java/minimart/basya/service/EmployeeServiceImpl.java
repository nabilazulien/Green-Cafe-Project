package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.request.EmployeeRequest;
import minimart.basya.model.Employee;
import minimart.basya.model.JobPosition;
import minimart.basya.model.LastEducation;
import minimart.basya.model.User;
import minimart.basya.repository.EmployeeRepository;
import minimart.basya.repository.JobPositionRepository;
import minimart.basya.repository.LastEducationRepository;
import minimart.basya.repository.UserRepository;
import minimart.basya.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<Object> CreateNewEmployee(EmployeeRequest employeeRequest, String token) {
        log.info("start create employee service");

        String loginName = jwtUtils.getUsernameFromToken(token);

        Optional<JobPosition> jobPositionByTitle = jobPositionRepository.findByTitle(employeeRequest.getJobPositionId());
        if (!jobPositionByTitle.isPresent()) {
            log.error("jobPositionId tidak sesuai");
            return new ResponseEntity<>("job jobPositionId tidak sesuai", HttpStatus.BAD_REQUEST);
        }

        Optional<LastEducation> lastEducationByName = lastEducationRepository.findByName(employeeRequest.getLastEducationId());
        if (!lastEducationByName.isPresent()) {
            log.error("lastEducationId tidak sesuai");
            return new ResponseEntity<>("lastEducationId tidak sesuai", HttpStatus.BAD_REQUEST);
        }

        Optional<User> userByLoginName = userRepository.findByLoginName(loginName);
        if (!userByLoginName.isPresent()) {
            log.error("token invalid");
            return new ResponseEntity<>("token tidak valid", HttpStatus.BAD_REQUEST);
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
        return new ResponseEntity<>("sukses", HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity<Object> UpdateEmployee(String id, EmployeeRequest employeeRequest, String token) {

        String loginName = jwtUtils.getUsernameFromToken(token);
        Optional<User> byLoginName = userRepository.findByLoginName(loginName);
        if (!byLoginName.isPresent()) {
            log.error("token tidak valid");
            return new ResponseEntity<>("token tidak valid", HttpStatus.BAD_REQUEST);
        }

        Optional<JobPosition> jobPositionByTitle = jobPositionRepository.findByTitle(employeeRequest.getJobPositionId());
        if (!jobPositionByTitle.isPresent()) {
            log.error("jobPositionId tidak sesuai");
            return new ResponseEntity<>("job jobPositionId tidak sesuai", HttpStatus.BAD_REQUEST);
        }

        Optional<LastEducation> lastEducationByName = lastEducationRepository.findByName(employeeRequest.getLastEducationId());
        if (!lastEducationByName.isPresent()) {
            log.error("lastEducationId tidak sesuai");
            return new ResponseEntity<>("lastEducationId tidak sesuai", HttpStatus.BAD_REQUEST);
        }

        Optional<Employee> employee = employeeRepository.findById(UUID.fromString(id));
        if (!employee.isPresent()) {
            log.error("employee tidak sesuai");
            return new ResponseEntity<>("employee tidak sesuai", HttpStatus.BAD_REQUEST);
        }

        employee.get().setFullName(employeeRequest.getFullName());
        employee.get().setGender(employeeRequest.getGender());
        employee.get().setDob(LocalDate.parse(employeeRequest.getDob()));
        employee.get().setPob(employeeRequest.getPob());
        employee.get().setEmail(employeeRequest.getEmail());
        employee.get().setMobilePhoneNumber(employeeRequest.getMobilePhoneNumber());
        employee.get().setJobPositionId(jobPositionByTitle.get());
        employee.get().setLastEducationId(lastEducationByName.get());
        employee.get().setUpdatedBy(byLoginName.get());
        employeeRepository.save(employee.get());
        log.info("update berhasil");
        return new ResponseEntity<>("sukses", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(String id, String token) {
        String loginName = jwtUtils.getUsernameFromToken(token);
        Optional<User> byLoginName = userRepository.findByLoginName(loginName);
        if(byLoginName.isPresent()){
            log.error("token tidak valid");
            return new ResponseEntity<>("token tidak valid", HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> byId = employeeRepository.findById(UUID.fromString(id));
        byId.get().setIsActive(false);
        byId.get().setUpdatedBy(byLoginName.get());
        employeeRepository.save(byId.get());
        return new ResponseEntity<>("sukses delete "+id+" : non aktive", HttpStatus.OK);
    }
}
