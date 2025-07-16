package ch.Elodin.DnD_Tool.repository;

import ch.Elodin.DnD_Tool.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ch.Elodin.DnD_Tool.model.Npc;

import java.util.List;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Integer> {
    @Query("SELECT n FROM Npc n WHERE n.shop_relations_ID.shop.shopId = :shopId AND n.shop_relations_ID.shopEmployeeRole IS NOT NULL")
    List<Npc> findEmployeesByShopId(@Param("shopId") Integer shopId);

    @Query("SELECT n FROM Npc n WHERE n.shop_relations_ID.shop.shopId = :shopId AND n.shop_relations_ID.shopCustomerRole IS NOT NULL")
    List<Npc> findCustomersByShopId(@Param("shopId") Integer shopId);


}
