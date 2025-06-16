package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.HairstyleRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Hairstyle;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Hairstyle")
public class HairstyleController extends GenericController<Hairstyle, Integer> {
    public HairstyleController(HairstyleRepository repository) {
        super(repository);
    }
}

