package ch.Elodin.DnD_Tool.repository.shop;

import ch.Elodin.DnD_Tool.model.shop.ShopRelations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRelationsRepository extends JpaRepository<ShopRelations, Integer> {
}
