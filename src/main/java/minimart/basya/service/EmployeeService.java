package minimart.basya.service;

import minimart.basya.dto.request.EmployeeRequest;
import minimart.basya.model.Employee;

public interface EmployeeService {
    Employee CreateNewEmployee(EmployeeRequest employeeRequest);
}
