package ch.Elodin.DnD_Tool.repository.shop;

import ch.Elodin.DnD_Tool.model.shop.ShopCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCustomerRepository extends JpaRepository<ShopCustomer, Integer> {
}
