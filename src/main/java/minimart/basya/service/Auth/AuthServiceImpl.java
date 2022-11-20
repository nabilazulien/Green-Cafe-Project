package minimart.basya.service.Auth;

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
import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity login(String loginName, String password) {
        Optional<User> byLoginName = userRepository.findByLoginName(loginName);
        if (!byLoginName.isPresent()) {
            return new ResponseEntity<>("LoginName tidak terdaftar", HttpStatus.BAD_REQUEST);
        }

        String passwordUser = byLoginName.get().getPassword();
        String passWordHass = HasPass.hass(password);

        if (!passWordHass.equals(passwordUser)) {
            return new ResponseEntity<>("password salah", HttpStatus.BAD_REQUEST);
        }

        String token = jwtUtils.generateToken(loginName);

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
