package minimart.basya.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import minimart.basya.model.User;

import java.util.UUID;

@Setter
@Getter
@ToString
public class ItemRequest {
    private String name;
    private String description;
    private String category;
    private String price;
    private User createdBy;
}
