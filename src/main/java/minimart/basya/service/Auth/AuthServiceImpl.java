package minimart.basya.service.Auth;

import minimart.basya.model.User;
import minimart.basya.repository.UserRepository;
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
        String passWordHass = hass(password);

        if (!passWordHass.equals(passwordUser)) {
            return new ResponseEntity<>("password salah", HttpStatus.BAD_REQUEST);
        }

        String token = jwtUtils.generateToken(loginName);

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    public String hass(String passwordToHash) {
        String generatedPassword = null;
        try {
            String salt = "lslkal";
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
