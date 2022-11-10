package minimart.basya.service;

import minimart.basya.dto.request.RegisterRequest;
import minimart.basya.model.User;

public interface UserService {
    User registerNewAccount(RegisterRequest registerRequest);

}
