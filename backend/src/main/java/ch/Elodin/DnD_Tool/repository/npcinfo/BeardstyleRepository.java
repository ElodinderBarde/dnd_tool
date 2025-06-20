package ch.Elodin.DnD_Tool.repository.npcinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Beardstyle;

@Repository
public interface BeardstyleRepository extends JpaRepository<Beardstyle, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Beardstyle> findAll();

	Optional<Beardstyle> findByname(String name);


}