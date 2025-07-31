package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.dto.NpcFilterRequest;
import ch.Elodin.DnD_Tool.dto.NpcReadDTO;
import ch.Elodin.DnD_Tool.dto.NpcWriteDTO;
import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.model.enums.EnumSymbol;
import ch.Elodin.DnD_Tool.model.npcinfo.Subclass;
import ch.Elodin.DnD_Tool.repository.ClanRepository;
import ch.Elodin.DnD_Tool.repository.NpcRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.RaceRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.SubclassRepository;
import ch.Elodin.DnD_Tool.service.NpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/npcs")
public class NpcController {

    private final NpcService npcService;
    private final RaceRepository raceRepository;
    private final SubclassRepository subclassRepository;
    private final NpcRepository npcRepository;
    private final ClanRepository clanRepository;
    private static final Logger LOG = LoggerFactory.getLogger(NpcController.class);


    public NpcController(NpcService npcService,
                         RaceRepository raceRepository,
                         SubclassRepository subclassRepository,
                         NpcRepository npcRepository,
                         ClanRepository clanRepository
                          ) {
        this.npcService = npcService;
        this.raceRepository = raceRepository;
        this.subclassRepository = subclassRepository;
        this.npcRepository = npcRepository;
        this.clanRepository = clanRepository;
    }


    @GetMapping("/dto")
    public List<NpcReadDTO> getAllAsDTO() {
        return npcService.getAllNpcs();
    }

    @GetMapping("/dto/filter")
    public List<NpcReadDTO> getFilteredNpcs(NpcFilterRequest filter) {
        return npcService.getFilteredNpcs(filter);
    }

    @GetMapping("/races/names")
    public List<String> getAllRaceNames() {
        return raceRepository.findAll().stream()
                .map(r -> r.getRacename())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/subclasses/names")
    public List<String> getAllSubclassNames() {
        return subclassRepository.findAll().stream()
                .map(s -> s.getSubclassname())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/clans/names")
    public List<String> getAllClanNames() {
        return clanRepository.findAll().stream()
                .map(c -> c.getClan())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/clanpositions/names")
    public List<String> getAllClanPositionNames() {
        return npcRepository.findAll().stream()
                .map(Npc::getClan_position)
                .filter(pos -> pos != null && !pos.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/classes/names")
    public List<String> getAllClassNames() {
        return npcRepository.findAll().stream()
                .map(npc -> npc.getNpcClass() != null ? npc.getNpcClass().getClassname() : null)
                .filter(name -> name != null && !name.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/subclasses/names/byClass")
    public List<String> getSubclassNamesByClass(@RequestParam(required = false) String npcClass) {
        if (npcClass == null || npcClass.isBlank()) return Collections.emptyList();
        return subclassRepository.findByClassname(npcClass).stream()
                .map(Subclass::getSubclassname)
                .distinct()
                .toList();
    }
    @GetMapping("/Subclasses/byClass/{classId}")
    public List<Subclass> getSubclassesByClassId(@PathVariable int classId) {
        return subclassRepository.findByClassId(classId);

    }



    @PutMapping("/{id}")
    public void updateNpcNotes(@PathVariable int id, @RequestBody NpcReadDTO dto) {
        Npc npc = npcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NPC nicht gefunden mit ID: " + id));

        npc.setNotes(dto.getNotes());
        npcRepository.save(npc);
    }
    @GetMapping("/{id}")
    public NpcReadDTO getNpcById(@PathVariable int id) {
        return npcService.getNpcById(id);
    }

    @PostMapping
    public ResponseEntity<?> createNpc(@RequestBody NpcWriteDTO dto) {
        try {
            npcService.createNpc(dto);
            LOG.info("Empfangener NPC DTO: {}", dto);
            return ResponseEntity.ok().build(); // 200 OK
        } catch (Exception e) {
            e.printStackTrace(); // für Debug-Zwecke
            LOG.info("Empfangener NPC DTO: {}", dto);

            return ResponseEntity.badRequest().body("Fehler beim Erstellen des NPCs: " + e.getMessage());
        }
    }
    @RestController
    @RequestMapping("/api/Symbol")
    public class SymbolController {

        @GetMapping
        public EnumSymbol[] getAllSymbols() {
            return EnumSymbol.values();
        }
    }

}
