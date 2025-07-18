package ch.Elodin.DnD_Tool.service;

import ch.Elodin.DnD_Tool.dto.NpcFilterRequest;
import ch.Elodin.DnD_Tool.dto.NpcReadDTO;
import ch.Elodin.DnD_Tool.dto.NpcWriteDTO;
import ch.Elodin.DnD_Tool.mapper.NpcMapper;
import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.model.npcinfo.*;
import ch.Elodin.DnD_Tool.repository.NpcRepository;
import ch.Elodin.DnD_Tool.repository.npcinfo.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NpcService {
    private final NpcRepository npcRepository;
    private final StatsRepository statsRepository;
    private final FirstnameRepository firstnameRepository;
    private final RaceRepository raceRepository;
    private final LevelRepository levelRepository;
    private final LastnameRepository lastnameRepository;
    private final GenderRepository genderRepository;
    private final PersonalityRepository personalityRepository;
    private final OtherDescriptionRepository otherDescriptionRepository;
    private final LikesRepository likesRepository;
    private final DislikesRepository dislikesRepository;
    private final IdealsRepository idealsRepository;
    private final KleidungQualiRepository kleidungQualiRepository;
    private final JacketsRepository jacketsRepository;
    private final TrousersRepository trousersRepository;
    private final HairstyleRepository hairstyleRepository;
    private final HaircolorRepository haircolorRepository;
    private final BeardstyleRepository beardstyleRepository;
    private final ArmorRepository armorRepository;

    public NpcService(NpcRepository npcRepository, StatsRepository statsRepository, FirstnameRepository firstnameRepository, RaceRepository raceRepository, LevelRepository levelRepository, LastnameRepository lastnameRepository, GenderRepository genderRepository, PersonalityRepository personalityRepository, OtherDescriptionRepository otherDescriptionRepository, LikesRepository likesRepository, DislikesRepository dislikesRepository, IdealsRepository idealsRepository, KleidungQualiRepository kleidungQualiRepository, JacketsRepository jacketsRepository, TrousersRepository trousersRepository, HairstyleRepository hairstyleRepository, HaircolorRepository haircolorRepository, BeardstyleRepository beardstyleRepository, ArmorRepository armorRepository) {
        this.npcRepository = npcRepository;
        this.statsRepository = statsRepository;
        this.firstnameRepository = firstnameRepository;
        this.raceRepository = raceRepository;
        this.levelRepository = levelRepository;
        this.lastnameRepository = lastnameRepository;
        this.genderRepository = genderRepository;
        this.personalityRepository = personalityRepository;
        this.otherDescriptionRepository = otherDescriptionRepository;
        this.likesRepository = likesRepository;
        this.dislikesRepository = dislikesRepository;
        this.idealsRepository = idealsRepository;
        this.kleidungQualiRepository = kleidungQualiRepository;
        this.jacketsRepository = jacketsRepository;
        this.trousersRepository = trousersRepository;
        this.hairstyleRepository = hairstyleRepository;
        this.haircolorRepository = haircolorRepository;
        this.beardstyleRepository = beardstyleRepository;
        this.armorRepository = armorRepository;
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

    public void createNpc(NpcWriteDTO dto) {
        Npc npc = new Npc();

        npc.setFirstname(firstnameRepository.findById(dto.getFirstnameId()).orElseThrow());
        npc.setRace(raceRepository.findById(dto.getRaceId()).orElseThrow());
        // usw. für alle Referenzen
        npc.setNotes(dto.getNotes());
        npc.setLevel(levelRepository.findById(dto.getLevelId()).orElseThrow());

        npcRepository.save(npc);
    }



    public void updateNpc(int id, NpcWriteDTO dto) {
        Npc npc = npcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NPC nicht gefunden mit ID: " + id));

        NpcMapper.updateEntityFromDto(npc, dto,
                firstnameRepository, lastnameRepository, genderRepository, raceRepository, levelRepository,
                personalityRepository, otherDescriptionRepository, likesRepository, dislikesRepository,
                idealsRepository, kleidungQualiRepository, jacketsRepository, trousersRepository,
                hairstyleRepository, haircolorRepository, beardstyleRepository, armorRepository
        );

        npcRepository.save(npc);
    }
    public Firstname getOrCreateFirstname(String name, Race race, Gender gender) {
        return firstnameRepository.findByFirstnameAndRaceAndGender(name, race, gender)
                .orElseGet(() -> {
                    Firstname newEntry = new Firstname();
                    newEntry.setFirstname(name);
                    newEntry.setRace(race);
                    newEntry.setGender(gender);
                    return firstnameRepository.save(newEntry);
                });
    }

    public Lastname getOrCreateLastname(String name, Race race) {
        return lastnameRepository.findByLastnameAndRace(name, race)
                .orElseGet(() -> {
                    Lastname newEntry = new Lastname();
                    newEntry.setLastname(name);
                    newEntry.setRace(race);
                    return lastnameRepository.save(newEntry);
                });
    }


}
