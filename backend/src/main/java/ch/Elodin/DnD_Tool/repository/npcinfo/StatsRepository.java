package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import ch.Elodin.DnD_Tool.model.Npc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Stats;


@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer> {
	Optional<Stats> findByNpc(Npc npc);

}

