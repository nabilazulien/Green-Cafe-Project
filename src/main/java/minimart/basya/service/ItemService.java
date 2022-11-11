package minimart.basya.service;

import minimart.basya.dto.request.ItemRequest;
import minimart.basya.model.Item;

public interface ItemService {
    Item CreateNewItem(ItemRequest itemRequest);
}
