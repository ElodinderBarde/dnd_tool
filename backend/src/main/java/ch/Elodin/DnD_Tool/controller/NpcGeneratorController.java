package ch.Elodin.DnD_Tool.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.repository.NpcRepository;
import ch.Elodin.DnD_Tool.service.NpcGeneratorService;

@RestController
@RequestMapping("/api/npc-generator")
public class NpcGeneratorController {

    private final NpcGeneratorService generatorService;
    private final NpcRepository npcRepository;

    public NpcGeneratorController(NpcGeneratorService generatorService, NpcRepository npcRepository) {
        this.generatorService = generatorService;
        this.npcRepository = npcRepository;
    }

    @PostMapping("/generate")
    public ResponseEntity<Npc> generateAndSave() {
        Npc npc = generatorService.generateRandomNpc();
        npcRepository.save(npc);
        return ResponseEntity.ok(npc);
    }



}
