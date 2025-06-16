package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.shop.Shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Shop")
public class ShopController extends GenericController<Shop, Integer> {
    public ShopController(ShopRepository repository) {
        super(repository);
    }
}

