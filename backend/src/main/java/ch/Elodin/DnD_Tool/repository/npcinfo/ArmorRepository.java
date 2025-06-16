package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Armor;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Integer> {

	List<Armor> findAll();


	Optional<Armor> findByacvalue(int acvalue);


}