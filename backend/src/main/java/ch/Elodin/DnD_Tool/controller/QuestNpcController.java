// QuestNpcController.java
package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.dto.QuestNpcDto;
import ch.Elodin.DnD_Tool.mapper.QuestNpcMapper;
import ch.Elodin.DnD_Tool.repository.QuestNpcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/questnpc")
@RequiredArgsConstructor
public class QuestNpcController {

    private final QuestNpcRepository questNpcRepository;

    @GetMapping
    public List<QuestNpcDto> getAll() {
        return questNpcRepository.findAll().stream()
                .map(QuestNpcMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-quest/{id}")
    public List<QuestNpcDto> getByQuest(@PathVariable int id) {
        return questNpcRepository.findByQuest_QuestID(id).stream()
                .map(QuestNpcMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-npc/{id}")
    public List<QuestNpcDto> getByNpc(@PathVariable int id) {
        return questNpcRepository.findByNpcId(id).stream()
                .map(QuestNpcMapper::toDto)
                .collect(Collectors.toList());
    }


}
