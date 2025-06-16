package ch.Elodin.DnD_Tool.repository.npcinfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.Elodin.DnD_Tool.model.npcinfo.*;

public interface BackgroundRepository extends JpaRepository<Background, Integer> {
    Optional<Background> findByName(String name);
}
