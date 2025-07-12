package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.dto.ShopDTO;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.model.world.Location;
import ch.Elodin.DnD_Tool.model.shop.ShopType;
import ch.Elodin.DnD_Tool.repository.world.LocationRepository;
import ch.Elodin.DnD_Tool.repository.shop.ShopTypeRepository;
import ch.Elodin.DnD_Tool.service.shop.ShopService;
import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/shops")
@CrossOrigin(origins = "http://localhost:5173")
public class ShopController {

    private final ShopService shopService;
    private final ShopTypeRepository shopTypeRepository;
    private final LocationRepository locationRepository;

    public ShopController(ShopService shopService, ShopTypeRepository shopTypeRepository, LocationRepository locationRepository) {
        this.shopService = shopService;
        this.shopTypeRepository = shopTypeRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public List<ShopDTO> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable Integer id) {
        return shopService.getShopById(id)
                .map(shopService::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO dto) {
        try {
            ShopType shopType = shopTypeRepository.findById(dto.getShopTypeId())
                    .orElseThrow(() -> new RuntimeException("ShopType nicht gefunden: ID " + dto.getShopTypeId()));

            Location location = locationRepository.findById(dto.getLocationId())
                    .orElseThrow(() -> new RuntimeException("Location nicht gefunden: ID " + dto.getLocationId()));

            Shop shop = shopService.fromDTO(dto, shopType, location);
            Shop saved = shopService.createShop(shop);
            return ResponseEntity.ok(shopService.toDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShopNote(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        Optional<Shop> optionalShop = shopService.getShopEntityById(id); // Sauberer Zugriff über Service
        if (optionalShop.isEmpty()) return ResponseEntity.notFound().build();

        Shop shop = optionalShop.get();
        shop.setNotes(body.get("notes"));

        Shop saved = shopService.saveShop(shop); // auch über Service

        return ResponseEntity.ok(saved);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<Object> deleteShop(@PathVariable Integer id) {
        return shopService.getShopById(id).map(shop -> {
            shopService.deleteShop(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
