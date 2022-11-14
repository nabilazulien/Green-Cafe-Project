package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.EmployeeRequest;
import minimart.basya.dto.request.ItemRequest;
import minimart.basya.model.Employee;
import minimart.basya.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody String request) {
        try {
            EmployeeRequest employeeRequest;
            ObjectMapper objectMapper = new ObjectMapper();
            employeeRequest = objectMapper.readValue(request, EmployeeRequest.class);
            return employeeService.CreateNewEmployee(employeeRequest);
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
