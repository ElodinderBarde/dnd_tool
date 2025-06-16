package ch.Elodin.DnD_Tool.repository.shop;

import ch.Elodin.DnD_Tool.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
