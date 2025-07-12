package ch.Elodin.DnD_Tool.service.shop;

import ch.Elodin.DnD_Tool.dto.ShopDTO;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.model.world.Location;
import ch.Elodin.DnD_Tool.model.shop.ShopType;
import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    // DTO-basierte Methode zur Rückgabe aller Shops
    public List<ShopDTO> getAllShops() {
        return shopRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Einzelnen Shop per ID holen (als Entity)
    public Optional<Shop> getShopById(Integer id) {
        return shopRepository.findById(id);
    }

    // Shop aus DTO speichern (Mapping extern!)
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(Integer id) {
        shopRepository.deleteById(id);
    }

    // Mapping Entity → DTO
    public ShopDTO toDTO(Shop shop) {
        return new ShopDTO(
                shop.getShopId(),
                shop.getName(),
                shop.getShop_type() != null ? shop.getShop_type().getId() : 0,
                shop.getShop_type() != null ? shop.getShop_type().getName() : null,
                shop.getLocation() != null ? shop.getLocation().getId() : 0,
                shop.getLocation() != null && shop.getLocation().getCityID() != null ? shop.getLocation().getCityID().getCity_name() : null,
                shop.getLocation() != null && shop.getLocation().getCityID() != null ? shop.getLocation().getCityID().getId() : 0,
                shop.getNotes()
        );

    }public Optional<Shop> getShopEntityById(Integer id) {
        return shopRepository.findById(id);
    }

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }


    // Mapping DTO → Entity (ShopType + Location muss übergeben werden)
    public Shop fromDTO(ShopDTO dto, ShopType shopType, Location location) {
        Shop shop = new Shop();
        shop.setShopId(dto.getId());
        shop.setName(dto.getName());
        shop.setNotes(dto.getNotes());
        shop.setShop_type(shopType);
        shop.setLocation(location);
        return shop;
    }
}
