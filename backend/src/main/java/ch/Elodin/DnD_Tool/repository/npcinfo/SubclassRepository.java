package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Subclass;

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, Integer> {

	List<Subclass> findAll();

	Optional<Subclass> findBysubclassname(String subclassname);


}