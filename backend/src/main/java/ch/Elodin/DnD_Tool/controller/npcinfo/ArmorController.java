package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Armor;
import ch.Elodin.DnD_Tool.repository.npcinfo.ArmorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Armor")
public class ArmorController extends GenericController<Armor, Integer> {
    public ArmorController(ArmorRepository repository) {
        super(repository);
    }
}
