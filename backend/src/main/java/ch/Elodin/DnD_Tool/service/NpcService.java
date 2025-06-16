package ch.Elodin.DnD_Tool.service;

import ch.Elodin.DnD_Tool.model.Npc;
import ch.Elodin.DnD_Tool.repository.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NpcService {

    @Autowired
    private NpcRepository npcRepository;

    public List<Npc> getAllNpcs() {
        return npcRepository.findAll();
    }

    public Npc getNpcById(int id) {
        return npcRepository.findById(id).orElse(null);
    }

    // später: createNpc(), updateNpc(), deleteNpc() usw.
}
