package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Beardstyle;
import ch.Elodin.DnD_Tool.repository.npcinfo.BeardstyleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Beardstyle")
public class BeardstyleController extends GenericController<Beardstyle, Integer> {
    public BeardstyleController(BeardstyleRepository repository) {
        super(repository);
    }
}
