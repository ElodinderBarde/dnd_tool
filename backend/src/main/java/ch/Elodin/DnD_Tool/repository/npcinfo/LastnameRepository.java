package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Lastname;

@Repository
public interface LastnameRepository extends JpaRepository<Lastname, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Lastname> findAll();

	Optional<Lastname> findByLastname(String lastname);


}