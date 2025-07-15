package ch.Elodin.DnD_Tool.repository.npcinfo;

import ch.Elodin.DnD_Tool.model.npcinfo.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubclassRepository extends JpaRepository<Subclass, Integer> {

	@Query("SELECT s FROM Subclass s WHERE LOWER(s.class_ID.classname) = LOWER(:classname)")
	List<Subclass> findByClassname(String classname);
}
