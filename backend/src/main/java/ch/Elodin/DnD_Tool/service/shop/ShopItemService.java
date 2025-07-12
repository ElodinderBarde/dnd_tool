package ch.Elodin.DnD_Tool.service.shop;

import ch.Elodin.DnD_Tool.dto.ShopItemDTO;
import ch.Elodin.DnD_Tool.mapper.ShopItemMapper;
import ch.Elodin.DnD_Tool.model.Item;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.model.shop.ShopItem;
import ch.Elodin.DnD_Tool.repository.ItemRepository;
import ch.Elodin.DnD_Tool.repository.shop.ShopItemRepository;
import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopItemService {

    private final ShopItemRepository shopItemRepository;
    private final ShopRepository shopRepository;
    private final ItemRepository itemRepository;

    public ShopItemService(ShopItemRepository shopItemRepository,
                           ShopRepository shopRepository,
                           ItemRepository itemRepository) {
        this.shopItemRepository = shopItemRepository;
        this.shopRepository = shopRepository;
        this.itemRepository = itemRepository;
    }

    /**
     * Gibt alle Items eines Shops als DTO-Liste zurück.
     */
    public List<ShopItemDTO> getItemsByShopId(Integer shopId) {
        return shopItemRepository.findByShop_ShopId(shopId).stream()
                .map(ShopItemMapper::toDTO)
                .toList();
    }

    /**
     * Aktualisiert die Menge eines ShopItems und gibt das aktualisierte DTO zurück.
     */
    public ShopItemDTO updateQuantity(Integer id, Integer newQuantity) {
        ShopItem shopItem = shopItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShopItem nicht gefunden: ID " + id));

        shopItem.setQuantity(newQuantity);
        ShopItem updated = shopItemRepository.save(shopItem);

        return ShopItemMapper.toDTO(updated);
    }

    /**
     * Fügt eine Liste an Items zu einem Shop hinzu und gibt DTOs der neuen Einträge zurück.
     */
    public List<ShopItemDTO> addItemsToShop(List<ShopItemDTO> itemsToAdd) {
        List<ShopItemDTO> result = new ArrayList<>();

        for (ShopItemDTO dto : itemsToAdd) {
            Shop shop = shopRepository.findById(dto.getShopId())
                    .orElseThrow(() -> new RuntimeException("Shop nicht gefunden: ID " + dto.getShopId()));

            Item item = itemRepository.findById(dto.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item nicht gefunden: ID " + dto.getItemId()));

            ShopItem shopItem = new ShopItem();
            shopItem.setShop(shop);
            shopItem.setItem(item);
            shopItem.setQuantity(dto.getQuantity());

            ShopItem saved = shopItemRepository.save(shopItem);
            result.add(ShopItemMapper.toDTO(saved));
        }

        return result;
    }
}
