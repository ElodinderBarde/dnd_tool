package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Jackets;

@Repository
public interface JacketsRepository extends JpaRepository<Jackets, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Jackets> findAll();

	Optional<Jackets> findByname(String name);


}