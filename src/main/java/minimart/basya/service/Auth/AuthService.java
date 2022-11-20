package minimart.basya.service.Auth;

import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity login(String loginName,String password);
}
