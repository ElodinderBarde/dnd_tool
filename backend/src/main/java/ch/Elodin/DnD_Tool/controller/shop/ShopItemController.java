package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.model.shop.ShopItem;
import ch.Elodin.DnD_Tool.repository.shop.ShopItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopItems")
@CrossOrigin(origins = "http://localhost:5173")
public class ShopItemController {

    private final ShopItemRepository shopItemRepository;

    @Autowired
    public ShopItemController(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }

    // Gibt alle ShopItems eines bestimmten Shops anhand der shopId zurück
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<ShopItem>> getItemsByShopId(@PathVariable("shopId") Integer shopId) {
        List<ShopItem> items = shopItemRepository.findByShop_ShopId(shopId);
        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(items);
        }
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



}
