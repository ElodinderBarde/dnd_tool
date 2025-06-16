package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.JacketsRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Jackets;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Jackets")
public class JacketsController extends GenericController<Jackets, Integer> {
    public JacketsController(JacketsRepository repository) {
        super(repository);
    }
}

