package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.ItemRequest;
import minimart.basya.model.Item;
import minimart.basya.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public ResponseEntity<Object> CreateNewItem(ItemRequest itemRequest) {
        Item item = new Item();
        item.setId(UUID.randomUUID());
        item.setName(itemRequest.getName());
        item.setDecription(itemRequest.getDescription());
        item.setCategory(itemRequest.getCategory());
        item.setPrice(Double.valueOf(itemRequest.getPrice()));
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy(itemRequest.getCreatedBy());
        itemRepository.save(item);
        log.info("save item berhasil");
        return new ResponseEntity<>("sukses", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> UpdateItem(String id, ItemRequest itemRequest) {
        Optional<Item> byId = itemRepository.findById(UUID.fromString(id));
        if (!byId.isPresent()){
            log.info("validasi tidak sesuai");
            return new ResponseEntity<>("item tidak sesuai", HttpStatus.BAD_REQUEST);
        }
        byId.get().setName(itemRequest.getName());
        byId.get().setCategory(itemRequest.getCategory());
        byId.get().setDecription(itemRequest.getDescription());
        byId.get().setPrice(Double.valueOf(itemRequest.getPrice()));
        byId.get().setUpdatedAt(LocalDateTime.now());
        itemRepository.save(byId.get());
        log.info("update item berhasil");
        return new ResponseEntity<>("sukses", HttpStatus.OK);
    }
}