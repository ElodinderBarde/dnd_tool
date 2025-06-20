package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Stats;



@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer>{
        @SuppressWarnings("null")
				@Override
	List<Stats> findAll();
	
	
}
