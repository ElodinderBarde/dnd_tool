package ch.Elodin.DnD_Tool.controller.ruf;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.ruf.Ruf;
import ch.Elodin.DnD_Tool.repository.ruf.RufRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Ruf")
public class RufController extends GenericController<Ruf, Integer> {
    public RufController(RufRepository repository) {
        super(repository);
    }
}

