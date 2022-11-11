package minimart.basya.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.ItemRequest;
import minimart.basya.model.Item;
import minimart.basya.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
@Slf4j

public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Item createItem(@RequestBody String request) {
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
}
