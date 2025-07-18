package ch.Elodin.DnD_Tool.controller.npcinfo;

import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.npcinfo.Subclass;
import ch.Elodin.DnD_Tool.repository.npcinfo.SubclassRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/Subclass") // Basis-URL für diesen Controller
public class SubclassController extends GenericController<Subclass, Integer> {

    private final SubclassRepository subclassRepository;

    public SubclassController(SubclassRepository repository) {
        super(repository);
        this.subclassRepository = repository;
    }

    public record SubclassDTO(Integer id, String name) {}

    @GetMapping("/names/byClass")
    public List<SubclassDTO> getSubclassNamesByClass(@RequestParam String npcClass) {
        return subclassRepository.findByClassname(npcClass).stream()
                .map(sc -> new SubclassDTO(sc.getSubclass_ID(), sc.getSubclassname()))
                .toList();
    }
}
