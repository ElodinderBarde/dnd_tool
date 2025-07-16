package ch.Elodin.DnD_Tool.service;

import ch.Elodin.DnD_Tool.dto.NpcFilterRequest;
import ch.Elodin.DnD_Tool.dto.NpcReadDTO;
import ch.Elodin.DnD_Tool.mapper.NpcMapper;
import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.model.npcinfo.Stats;
import ch.Elodin.DnD_Tool.repository.NpcRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.StatsRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NpcService {
    private final NpcRepository npcRepository;
    private final StatsRepository statsRepository;

    public NpcService(NpcRepository npcRepository, StatsRepository statsRepository) {
        this.npcRepository = npcRepository;
        this.statsRepository = statsRepository;
    }

    public List<NpcReadDTO> getAllNpcs() {
        return npcRepository.findAll().stream()
                .map(npc -> {
                    Stats stats = statsRepository.findByNpc(npc).orElse(null);
                    return NpcMapper.toReadDTO(npc, stats);
                })
                .collect(Collectors.toList());
    }


    public List<NpcReadDTO> getFilteredNpcs(NpcFilterRequest filter) {
        return npcRepository.findAll().stream()
                .filter(npc -> filter.getSearch() == null || filter.getSearch().isEmpty() ||
                        (npc.getFirstname() != null && npc.getFirstname().getFirstname().toLowerCase().contains(filter.getSearch().toLowerCase())) ||
                        (npc.getLastname() != null && npc.getLastname().getLastname().toLowerCase().contains(filter.getSearch().toLowerCase())))
                .filter(npc -> filter.getRace() == null || filter.getRace().isEmpty() ||
                        (npc.getRace() != null && npc.getRace().getRacename().equalsIgnoreCase(filter.getRace())))
                .filter(npc -> {
                    if ("__NONE__".equals(filter.getNpcClass())) {
                        return npc.getNpcClass() == null;
                    }
                    return filter.getNpcClass() == null || filter.getNpcClass().isEmpty()
                            || (npc.getNpcClass() != null && npc.getNpcClass().getClassname().equalsIgnoreCase(filter.getNpcClass()));
                })

                .filter(npc -> filter.getSubclass() == null || filter.getSubclass().isEmpty() ||
                        (npc.getSubclass() != null && npc.getSubclass().getSubclassname().equalsIgnoreCase(filter.getSubclass())))
                .filter(npc -> filter.getClan() == null || filter.getClan().isEmpty() ||
                        (npc.getClan() != null && npc.getClan().getClan().equalsIgnoreCase(filter.getClan())))
                .filter(npc -> filter.getClanPosition() == null || filter.getClanPosition().isEmpty() ||
                        (npc.getClan_position() != null && npc.getClan_position().equalsIgnoreCase(filter.getClanPosition())))
                .filter(npc -> filter.getHasPicture() == null ||
                        (filter.getHasPicture() && npc.getPicture() != null) ||
                        (!filter.getHasPicture() && npc.getPicture() == null))
                .filter(npc -> filter.getHasShop() == null ||
                        (filter.getHasShop() && npc.getShop_relations_ID() != null) ||
                        (!filter.getHasShop() && npc.getShop_relations_ID() == null))
                .filter(npc -> filter.getSymbol() == null || filter.getSymbol().isEmpty() ||
                        (npc.getSymbol() != null && npc.getSymbol().toString().equalsIgnoreCase(filter.getSymbol())))



                .filter(npc -> filter.getLocationId() == null ||
                (npc.getShop_relations_ID() != null &&
                        npc.getShop_relations_ID().getShop() != null &&
                        npc.getShop_relations_ID().getShop().getLocation() != null &&
                        npc.getShop_relations_ID().getShop().getLocation().getId() == filter.getLocationId()))

                .map(npc -> {
                    Stats stats = statsRepository.findByNpc(npc).orElse(null);
                    return NpcMapper.toReadDTO(npc, stats);
                })


                .collect(Collectors.toList());
    }

    public NpcReadDTO getNpcById(int id) {
        Npc npc = npcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NPC nicht gefunden mit ID: " + id));

        Stats stats = statsRepository.findByNpc(npc)
                .orElseGet(() -> statsRepository.findByNpc(npcRepository.findById(1).orElse(null)).orElse(null));

        return NpcMapper.toReadDTO(npc, stats);
    }


}
