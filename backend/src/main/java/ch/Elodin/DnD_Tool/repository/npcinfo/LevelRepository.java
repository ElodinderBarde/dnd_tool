package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Level> findAll();

	Optional<Level> findBylvlvalue(Integer lvl_value);


}