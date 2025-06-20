package ch.Elodin.DnD_Tool.repository.npcinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Betonung;

@Repository
public interface BetonungRepository extends JpaRepository<Betonung, Integer> {
        @SuppressWarnings("null")
				@Override
	List<Betonung> findAll();

	Optional<Betonung> findBybetonung(String betonung);


}