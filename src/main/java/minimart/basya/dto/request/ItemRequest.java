package minimart.basya.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
public class ItemRequest {
    private String name;
    private String description;
    private String category;
    private Double price;
    private UUID createdBy;
}
