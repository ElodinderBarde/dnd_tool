package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Dislikes;
import ch.Elodin.DnD_Tool.repository.npcinfo.DislikesRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Dislikes")
public class DislikesController extends GenericController<Dislikes, Integer> {
    public DislikesController(DislikesRepository repository) {
        super(repository);
    }
}
