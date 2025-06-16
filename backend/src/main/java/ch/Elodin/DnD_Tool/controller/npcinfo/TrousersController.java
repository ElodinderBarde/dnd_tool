package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.TrousersRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Trousers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Trousers")
public class TrousersController extends GenericController<Trousers, Integer> {
    public TrousersController(TrousersRepository repository) {
        super(repository);
    }
}

