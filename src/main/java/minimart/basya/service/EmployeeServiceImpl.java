package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.EmployeeRequest;
import minimart.basya.model.Employee;
import minimart.basya.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee CreateNewEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setFullName(employeeRequest.getFullName());
        employee.setGender(employeeRequest.getGender());
        employee.setDob(LocalDate.parse(employeeRequest.getDob()));
        employee.setPob(employeeRequest.getPob());
        employee.setEmail(employeeRequest.getEmail());
        employee.setMobilePhoneNumber(employeeRequest.getMobilePhoneNumber());
        employee.setCreatedAt(LocalDateTime.now());
//        employee.setCreatedBy(employeeRequest.getCreatedBy());
        employee.setIsActive(employeeRequest.getIsActive());
        employee.setJobPositionId(employeeRequest.getJobPositionId());
        employee.setLastEducationId(employeeRequest.getLastEducationId());
        employeeRepository.save(employee);
        log.info("save employee berhasil");
        return employee;
    }
}
