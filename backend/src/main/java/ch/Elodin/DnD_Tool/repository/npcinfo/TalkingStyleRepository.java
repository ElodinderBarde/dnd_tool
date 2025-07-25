package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.TalkingStyle;

@Repository
public interface TalkingStyleRepository extends JpaRepository<TalkingStyle, Integer> {
@SuppressWarnings("null")
	@Override
	List<TalkingStyle> findAll();

	Optional<TalkingStyle> findBydescription(String description);


}