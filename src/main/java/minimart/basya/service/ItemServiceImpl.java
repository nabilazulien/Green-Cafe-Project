package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.ItemRequest;
import minimart.basya.model.Item;
import minimart.basya.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item CreateNewItem(ItemRequest itemRequest) {
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
        return item;
    }
}