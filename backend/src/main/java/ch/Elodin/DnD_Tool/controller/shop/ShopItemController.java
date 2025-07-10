package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.dto.ItemDTO;
import ch.Elodin.DnD_Tool.dto.ShopItemDTO;
import ch.Elodin.DnD_Tool.model.Item;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.model.shop.ShopItem;
import ch.Elodin.DnD_Tool.repository.ItemRepository;
import ch.Elodin.DnD_Tool.repository.shop.ShopItemRepository;

import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/shopItems")
@CrossOrigin(origins = "http://localhost:5173")
public class ShopItemController {

    private final ShopItemRepository shopItemRepository;
    private final ShopRepository shopRepository;

    private final ItemRepository itemRepository;

    @Autowired
    public ShopItemController(ShopItemRepository shopItemRepository, ShopRepository shopRepository, ItemRepository itemRepository) {
        this.shopItemRepository = shopItemRepository;
        this.shopRepository = shopRepository;
        this.itemRepository = itemRepository;
    }

    // Gibt alle ShopItems eines bestimmten Shops anhand der shopId zurück
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<ShopItem>> getItemsByShopId(@PathVariable("shopId") Integer shopId) {
        List<ShopItem> items = shopItemRepository.findByShop_ShopId(shopId);

        // if (items.isEmpty()) {
        //    return ResponseEntity.noContent().build();
        // } else {
        //    return ResponseEntity.ok(items);
        // }


        return ResponseEntity.ok(items);
    }



    @PutMapping("/{id}/quantity")
    public ResponseEntity<ShopItem> updateQuantity(@PathVariable Integer id, @RequestBody Integer newQuantity) {
        Optional<ShopItem> optionalShopItem = shopItemRepository.findById(id);
        if (optionalShopItem.isPresent()) {
            ShopItem shopItem = optionalShopItem.get();
            shopItem.setQuantity(newQuantity);
            shopItemRepository.save(shopItem);
            return ResponseEntity.ok(shopItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/addItems")
    public ResponseEntity<?> addItemsToShop(@RequestBody List<ShopItemDTO> itemsToAdd) {
        try {
            System.out.println("Empfangene Items: " + itemsToAdd);

            List<ShopItem> savedItems = new ArrayList<>();

            for (ShopItemDTO dto : itemsToAdd) {
                System.out.println("ShopId: " + dto.getShopId() + ", ItemId: " + dto.getItemId() + ", Quantity: " + dto.getQuantity());

                ShopItem shopItem = new ShopItem();

                Shop shop = shopRepository.findById(dto.getShopId())
                        .orElseThrow(() -> new RuntimeException("Shop nicht gefunden: ID " + dto.getShopId()));

                Item item = itemRepository.findById(dto.getItemId())
                        .orElseThrow(() -> new RuntimeException("Item nicht gefunden: ID " + dto.getItemId()));

                shopItem.setShop(shop);
                shopItem.setItem(item);
                shopItem.setQuantity(dto.getQuantity());

                savedItems.add(shopItemRepository.save(shopItem));
            }

            return ResponseEntity.ok(savedItems);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fehler beim Hinzufügen von Items: " + e.getMessage());
        }
    }










}