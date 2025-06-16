package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.LastnameRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Lastname;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Lastname")
public class LastnameController extends GenericController<Lastname, Integer> {
    public LastnameController(LastnameRepository repository) {
        super(repository);
    }
}

