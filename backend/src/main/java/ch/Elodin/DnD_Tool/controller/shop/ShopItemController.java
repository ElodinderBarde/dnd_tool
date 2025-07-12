package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.dto.ShopItemDTO;
import ch.Elodin.DnD_Tool.service.shop.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shopItems")
@CrossOrigin(origins = "http://localhost:5173")
public class ShopItemController {

    private final ShopItemService shopItemService;

    @Autowired
    public ShopItemController(ShopItemService shopItemService) {
        this.shopItemService = shopItemService;
    }

    // NEU: ShopItems per ShopId laden
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<ShopItemDTO>> getItemsByShopId(@PathVariable("shopId") Integer shopId) {
        List<ShopItemDTO> items = shopItemService.getItemsByShopId(shopId);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/addItems")
    public ResponseEntity<?> addItemsToShop(@RequestBody List<ShopItemDTO> itemsToAdd) {
        try {
            List<ShopItemDTO> savedItems = shopItemService.addItemsToShop(itemsToAdd);
            return ResponseEntity.ok(savedItems);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fehler beim Hinzufügen von Items: " + e.getMessage());
        }
    }
    @PutMapping("/{shopItemId}/quantity")
    public ResponseEntity<?> updateQuantity(@PathVariable Integer shopItemId, @RequestBody Map<String, Integer> body) {
        Integer quantity = body.get("quantity");
        shopItemService.updateQuantity(shopItemId, quantity);
        return ResponseEntity.ok().build();
    }


}
