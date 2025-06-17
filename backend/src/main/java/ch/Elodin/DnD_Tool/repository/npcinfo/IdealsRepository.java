package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Ideals;

@Repository
public interface IdealsRepository extends JpaRepository<Ideals, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Ideals> findAll();

	Optional<Ideals> findByDescription(String description);


}