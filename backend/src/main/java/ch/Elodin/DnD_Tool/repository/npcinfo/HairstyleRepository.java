package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Hairstyle;

@Repository
public interface HairstyleRepository extends JpaRepository<Hairstyle, Integer> {

	List<Hairstyle> findAll();

	Optional<Hairstyle> findByname(String name);


}