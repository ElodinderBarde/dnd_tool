package ch.Elodin.DnD_Tool.repository.npcinfo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.Elodin.DnD_Tool.model.npcinfo.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {

	List<Likes> findAll();

	Optional<Likes> findBydescription(String description);


}