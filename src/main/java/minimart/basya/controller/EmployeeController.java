package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.request.EmployeeRequest;
import minimart.basya.service.EmployeeService;
import minimart.basya.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee(@RequestBody String request, @RequestHeader String token) {
        try {
            //instansiasi RegisterRequest.class
            EmployeeRequest employeeRequest;

            //proses mapping request
            ObjectMapper objectMapper = new ObjectMapper();
            employeeRequest = objectMapper.readValue(request, EmployeeRequest.class);

            // melakukan validasi request dengan memanggil method validas request
            ArrayList<String> error = new ArrayList<>();
            Boolean isValid = validasiRequest(employeeRequest, error);
            if (!isValid) {
                log.error("request terkena validasi");
                return new ResponseEntity<>("eror validasi : " + error, HttpStatus.BAD_REQUEST);
            }
            //masuk ke user service
            return employeeService.CreateNewEmployee(employeeRequest, token);
        } catch (Exception e) {
            //handle error saat masuk service
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateEmployee(@RequestBody String request, @RequestParam String id, @RequestHeader String token) {
        try {
            EmployeeRequest employeeRequest;
            ObjectMapper mapper = new ObjectMapper();
            employeeRequest = mapper.readValue(request, EmployeeRequest.class);
            ArrayList<String> error = new ArrayList<>();
            Boolean isValid = validasiRequest(employeeRequest, error);
            if (!isValid) {
                log.error("request terkena validasi");
                return new ResponseEntity<>("eror validasi : " + error, HttpStatus.BAD_REQUEST);
            }
            //masuk ke user service
            return employeeService.UpdateEmployee(id, employeeRequest, token);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteEmployee(@RequestParam String id, @RequestHeader String token) {
        try {
            //masuk ke user service
            return employeeService.deleteEmployee(id, token);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Boolean validasiRequest(EmployeeRequest employeeRequest, ArrayList<String> error) {
        log.info("validasi request employee");
        Boolean isFullName = RegexUtil.isName(employeeRequest.getFullName());
        if (!isFullName) {
            error.add("nama harus berupa huruf");
        }
        Boolean isGender = employeeRequest.getGender().equalsIgnoreCase("male") || employeeRequest.getGender().equalsIgnoreCase("female");
        if (!isGender) {
            error.add("gender harus male atau female");
        }
//        Boolean isDob = RegexUtil.isDob(employeeRequest.getDob());
//        if (!isDob){
//            error.add("tanggal lahir harus berupa angka");
//        }
        Boolean isPob = RegexUtil.isAlphaNum(employeeRequest.getPob());
        if (!isPob) {
            error.add("tempat lahir harus berupa huruf");
        }
        Boolean isEmail = RegexUtil.isValidEmail(employeeRequest.getEmail());
        if (!isEmail) {
            error.add("format email salah");
        }
        Boolean isMobilePhoneNumber = RegexUtil.isNoTelephone(employeeRequest.getMobilePhoneNumber());
        if (!isMobilePhoneNumber) {
            error.add("nomor harus diawali dengan +62");
        }
        if (error.size() > 0) {
            return false;
        }
        return true;
    }

}
