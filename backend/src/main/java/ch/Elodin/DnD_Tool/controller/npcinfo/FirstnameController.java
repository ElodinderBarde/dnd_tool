package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Firstname;
import ch.Elodin.DnD_Tool.repository.npcinfo.FirstnameRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Firstname")
public class FirstnameController extends GenericController<Firstname, Integer> {
    public FirstnameController(FirstnameRepository repository) {
        super(repository);
    }
}
