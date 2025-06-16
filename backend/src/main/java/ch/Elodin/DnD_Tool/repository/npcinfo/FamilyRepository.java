package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

	List<Family> findAll();


	Optional<Family> findByFamilienname(String familienname);


}