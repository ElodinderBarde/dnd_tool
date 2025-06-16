package ch.Elodin.DnD_Tool.repository.npcinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.NpcClass;

@Repository
public interface KlasseRepository extends JpaRepository<NpcClass, Integer> {

	List<NpcClass> findAll();

	Optional<NpcClass> findByClassname(String classname);

}