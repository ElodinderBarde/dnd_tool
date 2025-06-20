package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Dislikes;

@Repository
public interface DislikesRepository extends JpaRepository<Dislikes, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Dislikes> findAll();

	Optional<Dislikes> findByDescription(String description);


}