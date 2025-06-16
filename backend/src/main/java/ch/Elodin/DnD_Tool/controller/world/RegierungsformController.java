package ch.Elodin.DnD_Tool.controller.world;

import ch.Elodin.DnD_Tool.repository.world.RegierungsformRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.world.Regierungsform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Regierungsform")
public class RegierungsformController extends GenericController<Regierungsform, Integer> {
    public RegierungsformController(RegierungsformRepository repository) {
        super(repository);
    }
}

