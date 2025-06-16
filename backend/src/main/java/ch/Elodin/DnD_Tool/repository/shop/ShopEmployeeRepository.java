package ch.Elodin.DnD_Tool.repository.shop;

import ch.Elodin.DnD_Tool.model.shop.ShopEmployee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopEmployeeRepository extends JpaRepository<ShopEmployee, Integer> {
}
