package ch.Elodin.DnD_Tool.repository.shop;

import ch.Elodin.DnD_Tool.model.shop.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {
    List<ShopItem> findByShop_ShopId(Integer shopId);
}
