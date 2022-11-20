package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import minimart.basya.dto.request.request.LoginRequest;
import minimart.basya.service.Auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/login")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee(@RequestBody String request) {
        LoginRequest loginRequest;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            loginRequest = objectMapper.readValue(request, LoginRequest.class);
            return authService.login(loginRequest.getLoginName(), loginRequest.getPassword());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
