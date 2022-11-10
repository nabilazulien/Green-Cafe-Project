package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.RegisterRequest;
import minimart.basya.model.User;
import minimart.basya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody String request) {
        try {
            RegisterRequest registerRequest;
            ObjectMapper objectMapper = new ObjectMapper();
            registerRequest = objectMapper.readValue(request, RegisterRequest.class);
           return userService.registerNewAccount(registerRequest);
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
