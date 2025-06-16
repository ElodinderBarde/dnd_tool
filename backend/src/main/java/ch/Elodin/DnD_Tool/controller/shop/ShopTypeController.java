package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.repository.shop.ShopTypeRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.shop.ShopType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ShopType")
public class ShopTypeController extends GenericController<ShopType, Integer> {
    public ShopTypeController(ShopTypeRepository repository) {
        super(repository);
    }
}

