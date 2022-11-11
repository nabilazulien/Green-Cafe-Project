package minimart.basya.service;

import minimart.basya.dto.request.RegisterRequest;
import minimart.basya.model.User;

import java.util.UUID;

public interface UserService {
    User registerNewAccount(RegisterRequest registerRequest);
    User delete(UUID id);

}
