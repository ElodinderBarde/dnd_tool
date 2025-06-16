package ch.Elodin.DnD_Tool.repository;
import ch.Elodin.DnD_Tool.model.Npc;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Integer> {
List<Npc> findAll();

}