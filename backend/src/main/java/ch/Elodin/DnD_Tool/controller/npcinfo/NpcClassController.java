package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.KlasseRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.NpcClass;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/NpcClass")
public class NpcClassController extends GenericController<NpcClass, Integer> {
    public NpcClassController(KlasseRepository repository) {
        super(repository);
    }
}

