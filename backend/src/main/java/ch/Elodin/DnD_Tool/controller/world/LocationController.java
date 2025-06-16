package ch.Elodin.DnD_Tool.controller.world;

import ch.Elodin.DnD_Tool.repository.world.LocationRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.world.Location;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Location")
public class LocationController extends GenericController<Location, Integer> {
    public LocationController(LocationRepository repository) {
        super(repository);
    }
}

