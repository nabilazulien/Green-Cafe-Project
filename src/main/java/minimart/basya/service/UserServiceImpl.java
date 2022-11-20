package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.request.RegisterRequest;
import minimart.basya.model.User;
import minimart.basya.repository.UserRepository;

import minimart.basya.util.HasPass;
import minimart.basya.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public ResponseEntity<Object> registerNewAccount(RegisterRequest registerRequest) {
        log.info("Service register new account");
        //validasi user berdasarkan login name
        Optional<User> userByLogiName = userRepository.findByLoginName(registerRequest.getLoginName());
        if (userByLogiName.isPresent()) {
            log.info("userLogin sudah ada");
            return new ResponseEntity<>("userLogin sudah dipakai", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setLoginName(registerRequest.getLoginName());
        user.setPassword(HasPass.hass(registerRequest.getPassword()));
        user.setFullName(registerRequest.getFullName());
        user.setEmail(registerRequest.getEmail());
        user.setMobilePhoneNumber(registerRequest.getMobilePhoneNumber());
        user.setAddress(registerRequest.getAddress());
        user.setWorkPhoneNumber(registerRequest.getWorkPhoneNumber());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        log.info("save user berhasil");

        String token = jwtUtils.generateToken(user.getLoginName());

        HashMap<Object, Object> map = new HashMap<>();
        map.put("token", token);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delete(String token) {

        String loginName = jwtUtils.getUsernameFromToken(token);

        Optional<User> user = userRepository.findByLoginName(loginName);
        userRepository.delete(user.get());
        log.info("username telah dihapus dengan id--> " + loginName);
        return new ResponseEntity<>("Delete Succes", HttpStatus.OK);

    }

    @Override
    public ResponseEntity updateUser(String token,RegisterRequest registerRequest) {
        String loginName = jwtUtils.getUsernameFromToken(token);
        Optional<User> userByLoginName = userRepository.findByLoginName(loginName);
        if(!userByLoginName.isPresent()){
            return new ResponseEntity<>("Token failed",HttpStatus.BAD_REQUEST);
        }
        User user = userByLoginName.get();
        user.setLoginName(registerRequest.getLoginName());
        user.setPassword(HasPass.hass(registerRequest.getPassword()));
        user.setFullName(registerRequest.getFullName());
        user.setEmail(registerRequest.getEmail());
        user.setMobilePhoneNumber(registerRequest.getMobilePhoneNumber());
        user.setAddress(registerRequest.getAddress());
        user.setWorkPhoneNumber(registerRequest.getWorkPhoneNumber());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        log.info("update user berhasil");
        return new ResponseEntity<>("Sukses update",HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUser(String token) {
        String loginName = jwtUtils.getUsernameFromToken(token);
        Optional<User> user = userRepository.findByLoginName(loginName);
        if(!user.isPresent()){
            return new ResponseEntity<>("token failed",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user.get(),HttpStatus.OK);
    }


}
