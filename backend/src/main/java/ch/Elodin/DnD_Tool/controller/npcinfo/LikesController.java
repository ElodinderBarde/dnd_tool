package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.LikesRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Likes;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Likes")
public class LikesController extends GenericController<Likes, Integer> {
    public LikesController(LikesRepository repository) {
        super(repository);
    }
}

