package ch.Elodin.DnD_Tool.controller.ruf;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.ruf.RufKonflikte;
import ch.Elodin.DnD_Tool.model.ruf.RufKonflikteKey;
import ch.Elodin.DnD_Tool.repository.ruf.RufKonflikteRepository;

@RestController
@RequestMapping("/api/RufKonflikte")
public class RufKonflikteController extends GenericController<RufKonflikte, RufKonflikteKey> {
    public RufKonflikteController(RufKonflikteRepository repository) {
        super(repository);
    }
}


