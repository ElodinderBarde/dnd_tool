package ch.Elodin.DnD_Tool.repository.npcinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.Elodin.DnD_Tool.model.npcinfo.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
	// nichts überschreiben – findAll(), findById(), save() etc. kommen automatisch
}
