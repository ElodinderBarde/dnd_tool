package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.repository.ItemRepository;
import ch.Elodin.DnD_Tool.dto.ItemDTO;
import ch.Elodin.DnD_Tool.model.Item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:5137")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    
    @GetMapping("/resources")
    public List<String> getAllResources() {
        return itemRepository.findDistinctBuchValues();
    }

    
    
    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO dto) {

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
