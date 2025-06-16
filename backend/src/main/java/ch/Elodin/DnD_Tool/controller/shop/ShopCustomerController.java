package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.repository.shop.ShopCustomerRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.shop.ShopCustomer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ShopCustomer")
public class ShopCustomerController extends GenericController<ShopCustomer, Integer> {
    public ShopCustomerController(ShopCustomerRepository repository) {
        super(repository);
    }
}

