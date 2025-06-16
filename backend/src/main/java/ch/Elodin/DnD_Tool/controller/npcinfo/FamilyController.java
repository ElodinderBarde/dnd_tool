package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Family;
import ch.Elodin.DnD_Tool.repository.npcinfo.FamilyRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Family")
public class FamilyController extends GenericController<Family, Integer> {

    public FamilyController(FamilyRepository repository) {
        super(repository);
    }
}
