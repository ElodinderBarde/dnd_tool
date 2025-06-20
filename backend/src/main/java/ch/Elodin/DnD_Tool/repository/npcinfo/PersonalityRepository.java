package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Personality;

@Repository
public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Personality> findAll();

	Optional<Personality> findBydescription(String description);


}