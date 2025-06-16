package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.repository.shop.ShopEmployeeRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.shop.ShopEmployee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ShopEmployee")
public class ShopEmployeeController extends GenericController<ShopEmployee, Integer> {
    public ShopEmployeeController(ShopEmployeeRepository repository) {
        super(repository);
    }
}

