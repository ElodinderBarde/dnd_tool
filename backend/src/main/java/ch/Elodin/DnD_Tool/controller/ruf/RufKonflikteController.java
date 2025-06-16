package ch.Elodin.DnD_Tool.controller.ruf;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.ruf.RufKonflikte;
import ch.Elodin.DnD_Tool.repository.ruf.RufKonflikteRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/RufKonflikte")
public class RufKonflikteController extends GenericController<RufKonflikte, Integer> {
    public RufKonflikteController(RufKonflikteRepository repository) {
        super(repository);
    }
}

