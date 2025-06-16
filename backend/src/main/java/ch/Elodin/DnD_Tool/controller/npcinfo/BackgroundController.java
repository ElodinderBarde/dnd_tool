package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Background;
import ch.Elodin.DnD_Tool.repository.npcinfo.BackgroundRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/background")
public class BackgroundController extends GenericController<Background, Integer> {
    public BackgroundController(BackgroundRepository repository) {
        super(repository);
    }
}
