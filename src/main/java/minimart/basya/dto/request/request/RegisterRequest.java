package minimart.basya.dto.request.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterRequest {
    //membuat attribute register request
    private String loginName;
    private String password;
    private String fullName;
    private String email;
    private String mobilePhoneNumber;
    private String address;
    private String workPhoneNumber;
}
