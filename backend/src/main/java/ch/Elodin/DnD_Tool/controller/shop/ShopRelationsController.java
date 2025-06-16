package ch.Elodin.DnD_Tool.controller.shop;

import ch.Elodin.DnD_Tool.model.shop.ShopRelations;
import ch.Elodin.DnD_Tool.repository.shop.ShopRelationsRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ShopRelations")
public class ShopRelationsController extends GenericController<ShopRelations, Integer> {

    public ShopRelationsController(ShopRelationsRepository repository) {
        super(repository);
    }
}
