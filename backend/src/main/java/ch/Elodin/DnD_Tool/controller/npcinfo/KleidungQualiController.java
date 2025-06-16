package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.KleidungQualiRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.KleidungQuali;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/KleidungQuali")
public class KleidungQualiController extends GenericController<KleidungQuali, Integer> {
    public KleidungQualiController(KleidungQualiRepository repository) {
        super(repository);
    }
}

