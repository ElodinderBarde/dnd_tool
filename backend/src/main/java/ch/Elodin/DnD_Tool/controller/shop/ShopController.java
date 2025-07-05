package ch.Elodin.DnD_Tool.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/Shop")
@CrossOrigin(origins = "http://localhost:5173")
public class ShopController extends GenericController<Shop, Integer> {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopController(ShopRepository repository) {
        super(repository);
        this.shopRepository = repository;
    }

    @PutMapping("/{id}/notes")
    public ResponseEntity<Shop> updateShopNotes(@PathVariable Integer id, @RequestBody String newNotes) {
        // Quotes entfernen, falls vorhanden
        if (newNotes != null && newNotes.startsWith("\"") && newNotes.endsWith("\"")) {
            newNotes = newNotes.substring(1, newNotes.length() - 1);
        }

        Optional<Shop> optionalShop = shopRepository.findById(id);
        if (optionalShop.isPresent()) {
            Shop shop = optionalShop.get();
            shop.setNotes(newNotes);
            shopRepository.save(shop);
            return ResponseEntity.ok(shop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
