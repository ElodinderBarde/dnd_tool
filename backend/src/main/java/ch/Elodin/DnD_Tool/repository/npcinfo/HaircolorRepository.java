package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Haircolor;

@Repository
public interface HaircolorRepository extends JpaRepository<Haircolor, Integer> {

	List<Haircolor> findAll();

	Optional<Haircolor> findByname(String name);


}