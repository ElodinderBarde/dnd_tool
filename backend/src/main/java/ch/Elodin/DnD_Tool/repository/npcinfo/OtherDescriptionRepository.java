package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.OtherDescription;

@Repository
public interface OtherDescriptionRepository extends JpaRepository<OtherDescription, Integer> {

	List<OtherDescription> findAll();

	Optional<OtherDescription> findBydescription(String description);


}