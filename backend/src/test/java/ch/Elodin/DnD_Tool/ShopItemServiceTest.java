package ch.Elodin.DnD_Tool;

import ch.Elodin.DnD_Tool.dto.ItemDTO;
import ch.Elodin.DnD_Tool.dto.ShopItemDTO;
import ch.Elodin.DnD_Tool.model.Item;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.model.shop.ShopItem;
import ch.Elodin.DnD_Tool.repository.ItemRepository;
import ch.Elodin.DnD_Tool.repository.shop.ShopItemRepository;
import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;
import ch.Elodin.DnD_Tool.service.shop.ShopItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ShopItemServiceTest {

    private ShopItemRepository shopItemRepository;
    private ShopRepository shopRepository;
    private ItemRepository itemRepository;
    private ShopItemService shopItemService;

    @BeforeEach
    public void setUp() {
        shopItemRepository = mock(ShopItemRepository.class);
        shopRepository = mock(ShopRepository.class);
        itemRepository = mock(ItemRepository.class);

        shopItemService = new ShopItemService(shopItemRepository, shopRepository, itemRepository);
    }

    @Test
    public void testAddItemsToShop_successfullySaves() {
        // Dummy ItemDTO
        ItemDTO dummyItem = new ItemDTO();
        dummyItem.setId(100);
        dummyItem.setName("Dummy");

        // ShopItemDTO mit 5 Parametern
        ShopItemDTO dto = new ShopItemDTO(
                null,     // shopItemId
                1,        // shopId
                100,      // itemId
                5,        // quantity
                dummyItem // eingebettetes ItemDTO
        );

        // Mock-Entitäten vorbereiten
        Shop mockShop = new Shop();
        mockShop.setShopId(1);

        Item mockItem = new Item();
        mockItem.setItemID(100);

        ShopItem savedShopItem = new ShopItem();
        savedShopItem.setShop(mockShop);
        savedShopItem.setItem(mockItem);
        savedShopItem.setQuantity(5);

        // Verhalten der Mocks definieren
        when(shopRepository.findById(1)).thenReturn(Optional.of(mockShop));
        when(itemRepository.findById(100)).thenReturn(Optional.of(mockItem));
        when(shopItemRepository.save(any(ShopItem.class))).thenReturn(savedShopItem);

        // Methode testen
        List<ShopItemDTO> result = shopItemService.addItemsToShop(List.of(dto));

        // Ergebnisse prüfen
        assertEquals(1, result.size());
        ShopItemDTO resultItem = result.get(0);
        assertEquals(1, resultItem.getShopId());
        assertEquals(100, resultItem.getItemId());
        assertEquals(5, resultItem.getQuantity());

        // Interaktionen prüfen
        verify(shopRepository, times(1)).findById(1);
        verify(itemRepository, times(1)).findById(100);
        verify(shopItemRepository, times(1)).save(any(ShopItem.class));
    }
}
