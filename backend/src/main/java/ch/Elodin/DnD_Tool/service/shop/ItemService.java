package ch.Elodin.DnD_Tool.service.shop;

import ch.Elodin.DnD_Tool.dto.ItemDTO;
import ch.Elodin.DnD_Tool.model.Item;
import ch.Elodin.DnD_Tool.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getAllResources() {
        return itemRepository.findDistinctBuchValues();
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ItemDTO createItem(ItemDTO dto) {
        Item item = new Item();
        item.setItemName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setTyp(dto.getTyp());
        item.setSeltenheit(dto.getSeltenheit());
        item.setBuch(dto.getBuch());
        item.setSeite1(dto.getSeite1());
        item.setSeite2(dto.getSeite2());
        item.setSeite3(dto.getSeite3());
        item.setEinstimmung(dto.getEinstimmung());
        item.setBeschreibung(dto.getBeschreibung());

        Item saved = itemRepository.save(item);
        return toDTO(saved);
    }

    private ItemDTO toDTO(Item item) {
        return new ItemDTO(
                item.getItemID(),
                item.getItemName(),
                item.getPrice(),
                item.getTyp(),
                item.getSeltenheit(),
                item.getBuch(),
                item.getSeite1(),
                item.getSeite2(),
                item.getSeite3(),
                item.getEinstimmung(),
                item.getBeschreibung()
        );
    }
}
