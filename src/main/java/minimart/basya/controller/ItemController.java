package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.request.ItemRequest;
import minimart.basya.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
@Slf4j

public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createItem(@RequestBody String request) {
        try {
            ItemRequest itemRequest;
            ObjectMapper objectMapper = new ObjectMapper();
            itemRequest = objectMapper.readValue(request, ItemRequest.class);
            return itemService.CreateNewItem(itemRequest);
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateEmployee(@RequestBody String request, @RequestParam String id) {
        try {
            ItemRequest itemRequest;
            ObjectMapper mapper = new ObjectMapper();
            itemRequest = mapper.readValue(request, ItemRequest.class);
            return itemService.UpdateItem(id, itemRequest);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
