package ch.Elodin.DnD_Tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.Elodin.DnD_Tool.model.Npc;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Integer> {
}
