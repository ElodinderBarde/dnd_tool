package ch.Elodin.DnD_Tool.controller.shop;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.shop.Shop;
import ch.Elodin.DnD_Tool.repository.shop.ShopRepository;

@RestController
@RequestMapping("/api/Shop")
@CrossOrigin(origins = "http://localhost:5173")

public class ShopController extends GenericController<Shop, Integer> {
    public ShopController(ShopRepository repository) {
        super(repository);
    }
}

