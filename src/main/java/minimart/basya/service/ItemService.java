package minimart.basya.service;

import minimart.basya.dto.request.request.ItemRequest;
import org.springframework.http.ResponseEntity;

public interface ItemService {
    ResponseEntity<Object> CreateNewItem(ItemRequest itemRequest);

    ResponseEntity<Object>UpdateItem(String id, ItemRequest itemRequest);
}
