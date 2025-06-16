package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.repository.npcinfo.TalkingStyleRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.TalkingStyle;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/TalkingStyle")
public class TalkingStyleController extends GenericController<TalkingStyle, Integer> {
    public TalkingStyleController(TalkingStyleRepository repository) {
        super(repository);
    }
}

