package minimart.basya.service;

import minimart.basya.dto.request.request.RegisterRequest;
import minimart.basya.model.User;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserService {
    ResponseEntity registerNewAccount(RegisterRequest registerRequest);
    User delete(UUID id);
}
