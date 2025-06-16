package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.OtherDescriptionRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.OtherDescription;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/OtherDescription")
public class OtherDescriptionController extends GenericController<OtherDescription, Integer> {
    public OtherDescriptionController(OtherDescriptionRepository repository) {
        super(repository);
    }
}

