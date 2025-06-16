package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Betonung;
import ch.Elodin.DnD_Tool.repository.npcinfo.BetonungRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Betonung")
public class BetonungController extends GenericController<Betonung, Integer> {
    public BetonungController(BetonungRepository repository) {
        super(repository);
    }
}
