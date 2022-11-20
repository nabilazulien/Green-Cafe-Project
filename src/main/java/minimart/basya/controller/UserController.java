package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.request.RegisterRequest;
import minimart.basya.service.UserService;
import minimart.basya.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody String request) {
        try {
            //instansiasi RegisterRequest.class
            RegisterRequest registerRequest;

            //proses mapping request
            ObjectMapper objectMapper = new ObjectMapper();
            registerRequest = objectMapper.readValue(request, RegisterRequest.class);

            // melakukan validasi request dengan memanggil method validas request
            ArrayList<String> error = new ArrayList<>();
            Boolean isValid = validasiRequest(registerRequest, error);
            if (!isValid) {
                log.error("request belum sesuai");
                return new ResponseEntity<>("error validasi : " + error, HttpStatus.BAD_REQUEST);
            }
            //masuk ke user service
            return userService.registerNewAccount(registerRequest);
        } catch (Exception e) {
            //handle error saat masuk service
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteUser(@RequestHeader String token) {
        try {
            return userService.delete(token);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestHeader String token,@RequestBody String request) {
        try {
            //instansiasi RegisterRequest.class
            RegisterRequest registerRequest;

            //proses mapping request
            ObjectMapper objectMapper = new ObjectMapper();
            registerRequest = objectMapper.readValue(request, RegisterRequest.class);

            // melakukan validasi request dengan memanggil method validas request
            ArrayList<String> error = new ArrayList<>();
            Boolean isValid = validasiRequest(registerRequest, error);
            if (!isValid) {
                log.error("request belum sesuai");
                return new ResponseEntity<>("error validasi : " + error, HttpStatus.BAD_REQUEST);
            }
            return userService.updateUser(token,registerRequest);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getUser(@RequestHeader String token) {
        try {
            return userService.getUser(token);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






    public Boolean validasiRequest(RegisterRequest registerRequest, ArrayList<String> error) {
        Boolean isLoginName = RegexUtil.isAlphaNum(registerRequest.getLoginName());
        if (!isLoginName) {
            error.add("loginName hanya boleh angka dan huruf tanpa spasi");
        }
        Boolean isPassword = RegexUtil.isPassword(registerRequest.getPassword());
        if (!isPassword) {
            error.add("password harus mengandung huruf  angka  karakter  kapital min 8 karakter");

        }
        Boolean isFullName = RegexUtil.isName(registerRequest.getFullName());
        if (!isFullName) {
            error.add("nama hanya boleh huruf dan spasi");
        }
        Boolean isEmail = RegexUtil.isValidEmail(registerRequest.getEmail());
        if (!isEmail) {
            error.add("format email salah");
        }
        Boolean isMobilePhoneNumber = RegexUtil.isNoTelephone(registerRequest.getMobilePhoneNumber());
        if (!isMobilePhoneNumber) {
            error.add("nomor harus diawali dengan +62");
        }
        Boolean isAddress = RegexUtil.isAddress(registerRequest.getAddress());
        if (!isAddress) {
            error.add("alamat tidak sesuai format");
        }
        Boolean isWorkPhoneNumber = RegexUtil.isNoTelephone(registerRequest.getWorkPhoneNumber());
        if (!isWorkPhoneNumber) {
            error.add("work phone number tidak valid");
        }
        if (error.size() > 0) {
            return false;
        }
        return true;
    }

}
