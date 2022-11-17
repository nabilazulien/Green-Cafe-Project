package minimart.basya.service;

import minimart.basya.dto.request.EmployeeRequest;
import org.springframework.http.ResponseEntity;


public interface EmployeeService {
    ResponseEntity<Object> CreateNewEmployee(EmployeeRequest employeeRequest);
}
