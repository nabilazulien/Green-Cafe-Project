package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.RegisterRequest;
import minimart.basya.model.User;
import minimart.basya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerNewAccount(RegisterRequest registerRequest) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setLoginName(registerRequest.getLoginName());
        user.setPassword(registerRequest.getPassword());
        user.setFullName(registerRequest.getFullName());
        user.setEmail(registerRequest.getEmail());
        user.setMobilePhoneNumber(registerRequest.getMobilePhoneNumber());
        user.setAddress(registerRequest.getAddress());
        user.setWorkPhoneNumber(registerRequest.getWorkPhoneNumber());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        log.info("save user berhasil");
        return user;
    }
}
