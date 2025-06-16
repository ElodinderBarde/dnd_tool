package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Flaw;

@Repository
public interface FlawRepository extends JpaRepository<Flaw, Integer> {

	List<Flaw> findAll();

	Optional<Flaw> findByDescription(String description);


}