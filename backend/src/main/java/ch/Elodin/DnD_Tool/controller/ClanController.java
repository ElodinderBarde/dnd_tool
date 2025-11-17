package ch.Elodin.DnD_Tool.controller;

import ch.Elodin.DnD_Tool.dto.ClanDTO;
import ch.Elodin.DnD_Tool.mapper.ClanMapper;
import ch.Elodin.DnD_Tool.repository.ClanRepository;
import ch.Elodin.DnD_Tool.model.Clan;


import ch.Elodin.DnD_Tool.repository.NpcRepository;
import ch.Elodin.DnD_Tool.service.NpcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/clan")
public class ClanController {

    private final ClanRepository clanRepository;

    public ClanController(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @GetMapping
    public List<ClanDTO> getAllClans() {
        return clanRepository.findAll()
                .stream()
                .map(ClanMapper::toClanDTO)
                .toList();
    }

    @GetMapping("/ClanNames")
    public List<String> getAllClanNames() {
        return (List<String>) clanRepository.findAllClanNames();
    }

    @GetMapping("/Familienclans")
    public List<ClanDTO> getFamilienclans() {
        return clanRepository.findAllFamilienclans()
                .stream()
                .map(ClanMapper::toClanDTO)
                .toList();
    }

    @GetMapping("/NonFamilienclans")
    public List<ClanDTO> getNonFamilienclans() {
        return clanRepository.findAllNonFamilienclans()
                .stream()
                .map(ClanMapper::toClanDTO)
                .toList();
    }

    @PostMapping("/createClan")
    public ClanDTO createClan(@RequestBody Clan clan) {
        Clan saved = clanRepository.save(clan);
        return ClanMapper.toClanDTO(saved);
    }
}


