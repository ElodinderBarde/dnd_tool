package ch.Elodin.DnD_Tool.service;

import ch.Elodin.DnD_Tool.model.npcinfo.Race;
import ch.Elodin.DnD_Tool.repository.npcinfo.RaceRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }
}
