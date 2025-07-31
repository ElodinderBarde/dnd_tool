package ch.Elodin.DnD_Tool.controller.world;

import ch.Elodin.DnD_Tool.dto.NpcWriteDTO;
import ch.Elodin.DnD_Tool.service.NpcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController



@RequestMapping("/api/npcs")
public class NpcWriteController {

    private final NpcService npcService;

    public NpcWriteController(NpcService npcService) {
        this.npcService = npcService;
    }

    @PostMapping
    public ResponseEntity<Void> createNpc(@RequestBody NpcWriteDTO dto) {
        npcService.createNpc(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNpc(@PathVariable int id, @RequestBody NpcWriteDTO dto) {
        npcService.updateNpc(id, dto);
        return ResponseEntity.ok().build();
    }
}
