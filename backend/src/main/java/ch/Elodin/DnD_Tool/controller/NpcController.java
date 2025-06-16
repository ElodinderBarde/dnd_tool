package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.repository.NpcRepository;
import ch.Elodin.DnD_Tool.model.Npc;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/npcs")
public class NpcController extends GenericController<Npc, Integer> {
    public NpcController(NpcRepository repository) {
        super(repository);
    }
}

