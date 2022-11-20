package minimart.basya.service;

import minimart.basya.dto.request.request.EmployeeRequest;
import org.springframework.http.ResponseEntity;


public interface EmployeeService {
    ResponseEntity<Object> CreateNewEmployee(EmployeeRequest employeeRequest,String token);

    ResponseEntity<Object> UpdateEmployee(String id, EmployeeRequest employeeRequest,String token);
    ResponseEntity<Object> deleteEmployee(String id,String token);
}
