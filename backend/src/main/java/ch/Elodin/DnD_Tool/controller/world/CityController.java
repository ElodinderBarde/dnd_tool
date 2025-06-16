package ch.Elodin.DnD_Tool.controller.world;

import ch.Elodin.DnD_Tool.repository.world.CityRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.world.City;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/City")
public class CityController extends GenericController<City, Integer> {
    public CityController(CityRepository repository) {
        super(repository);
    }
}

