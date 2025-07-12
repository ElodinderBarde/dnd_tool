package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.dto.ItemDTO;
import ch.Elodin.DnD_Tool.service.shop.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5137")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/resources")
    public List<String> getAllResources() {
        return itemService.getAllResources();
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO dto) {
        return itemService.createItem(dto);
    }
}
